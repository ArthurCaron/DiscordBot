package io.karon.discord_bot.domain.input_port.dynamic_private_thread

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort

data class CreateDynamicPrivateChannelRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val guildId: Long,
	val currentGuildTextChannel: GuildTextChannelPort
)
