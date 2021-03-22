package io.karon.discordbot.domain.input_port.answer_pong_to_ping

import io.karon.discordbot.domain.output_port.GuildTextChannelPort

data class AnswerPongToPingRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val currentGuildTextChannel: GuildTextChannelPort
)
