package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.repository_port.TextChannelRepository
import io.karon.discord_bot.infrastructure.output_adapter.GuildTextChannelAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class TextChannelRepositoryAdapter(private val jda: JDA) : TextChannelRepository {
	override fun getTextChannelByName(channelName: String): GuildTextChannelPort? {
		return jda.getTextChannelsByName(channelName, false).firstOrNull()?.let {
			GuildTextChannelAdapter(it)
		}
	}

	override suspend fun createTextChannel(channelName: String, categoryName: String): GuildTextChannelPort? {
		return jda.getCategoriesByName(categoryName, false)
			.firstOrNull()
			?.createTextChannel(channelName)
			?.awaitCallback()
			?.let { GuildTextChannelAdapter(it) }
	}
}
