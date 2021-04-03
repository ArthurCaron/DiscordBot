package io.karon.discord_bot.domain.repository_adapter

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort

interface TextChannelRepository {
	fun getTextChannelByName(channelName: String): GuildTextChannelPort?
	fun createTextChannel(channelName: String, categoryName: String, onSuccess: (GuildTextChannelPort) -> Unit)
}
