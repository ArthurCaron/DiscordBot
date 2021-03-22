package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.GuildTextChannelPort

interface TextChannelRepository {
	fun getTextChannelByName(channelName: String): GuildTextChannelPort?
	fun createPrivateTextChannel(channelName: String, categoryName: String, onSuccess: (GuildTextChannelPort) -> Unit)
}
