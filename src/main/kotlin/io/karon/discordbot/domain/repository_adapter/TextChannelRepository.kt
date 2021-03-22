package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.GuildTextChannel

interface TextChannelRepository {
	fun getTextChannelByName(channelName: String): GuildTextChannel?
	fun createPrivateTextChannel(channelName: String, categoryName: String, onSuccess: (GuildTextChannel) -> Unit)
}
