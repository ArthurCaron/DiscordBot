package io.karon.discord_bot.domain.input_port.answer_pong_to_ping

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort

open class AnswerPongToPing {
	suspend fun execute(input: Request) {
		if (input.isAuthorABot) return
		if (input.messageReceived == "!ping") {
			input.currentGuildTextChannel.sendMessage("PONG")
		}
	}

	data class Request(
		val isAuthorABot: Boolean,
		val messageReceived: String,
		val currentGuildTextChannel: GuildTextChannelPort
	)
}
