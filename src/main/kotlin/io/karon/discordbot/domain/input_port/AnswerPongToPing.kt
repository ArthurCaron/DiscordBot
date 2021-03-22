package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.AnswerPongToPingRequest

open class AnswerPongToPing {
	fun execute(input: AnswerPongToPingRequest) {
		if (input.isAuthorABot) return
		if (input.messageReceived == "!ping") {
			input.currentGuildTextChannel.sendMessage("PONG")
		}
	}
}
