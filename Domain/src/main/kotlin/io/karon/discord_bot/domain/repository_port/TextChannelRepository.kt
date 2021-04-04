package io.karon.discord_bot.domain.repository_port

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort

interface TextChannelRepository {
	fun getTextChannelByName(channelName: String): GuildTextChannelPort?
	suspend fun createTextChannel(channelName: String, categoryName: String): GuildTextChannelPort?
}
