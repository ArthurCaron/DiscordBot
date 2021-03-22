package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.repository_adapter.TextChannelRepository
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

	override fun createPrivateTextChannel(channelName: String, categoryName: String, onSuccess: (GuildTextChannelPort) -> Unit) {
		jda.getCategoriesByName(categoryName, false).firstOrNull()
			?.createTextChannel(channelName)
			?.queue {
				onSuccess(GuildTextChannelAdapter(it))
			}
	}
}
