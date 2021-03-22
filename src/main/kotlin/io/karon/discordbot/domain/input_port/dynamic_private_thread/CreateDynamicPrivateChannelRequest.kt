package io.karon.discordbot.domain.input_port.dynamic_private_thread

import io.karon.discordbot.domain.output_port.GuildTextChannelPort

data class CreateDynamicPrivateChannelRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val guildId: Long,
	val currentGuildTextChannel: GuildTextChannelPort
)
