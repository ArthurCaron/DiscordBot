package io.karon.discordbot.domain.input_port.answer_pong_to_ping

open class AnswerPongToPing {
	fun execute(input: AnswerPongToPingRequest) {
		if (input.isAuthorABot) return
		if (input.messageReceived == "!ping") {
			input.currentGuildTextChannel.sendMessage("PONG")
		}
	}
}
