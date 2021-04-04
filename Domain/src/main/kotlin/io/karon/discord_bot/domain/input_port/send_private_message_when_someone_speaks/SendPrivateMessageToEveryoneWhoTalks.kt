package io.karon.discord_bot.domain.input_port.send_private_message_when_someone_speaks

import io.karon.discord_bot.domain.repository_port.UserRepository

// TODO: unused
open class SendPrivateMessageToEveryoneWhoTalks(private val userRepository: UserRepository) {
	fun execute(input: Request) {
		if (input.isAuthorABot) return
		userRepository.getUserById(input.userId)
			?.sendMessage("HEEEELLLOOO :)")
	}

	data class Request(
		val isAuthorABot: Boolean,
		val userId: String
	)
}
