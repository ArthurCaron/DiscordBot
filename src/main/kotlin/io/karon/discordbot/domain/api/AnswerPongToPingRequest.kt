package io.karon.discordbot.domain.api

import io.karon.discordbot.domain.output_port.GuildTextChannel

data class AnswerPongToPingRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val currentGuildTextChannel: GuildTextChannel
)
