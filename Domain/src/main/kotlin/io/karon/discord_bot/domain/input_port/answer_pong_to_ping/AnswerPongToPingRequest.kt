package io.karon.discord_bot.domain.input_port.answer_pong_to_ping

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort

data class AnswerPongToPingRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val currentGuildTextChannel: GuildTextChannelPort
)
