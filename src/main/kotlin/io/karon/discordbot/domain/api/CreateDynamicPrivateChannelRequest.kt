package io.karon.discordbot.domain.api

import io.karon.discordbot.domain.output_port.GuildTextChannel

data class CreateDynamicPrivateChannelRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val guildId: Long,
	val currentGuildTextChannel: GuildTextChannel
)
