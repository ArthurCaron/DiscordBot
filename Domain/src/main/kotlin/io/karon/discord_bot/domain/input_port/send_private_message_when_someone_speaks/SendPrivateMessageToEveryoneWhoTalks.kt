package io.karon.discord_bot.domain.input_port.send_private_message_when_someone_speaks

import io.karon.discord_bot.domain.repository_adapter.UserRepository

open class SendPrivateMessageToEveryoneWhoTalks(private val userRepository: UserRepository) {
	fun execute(input: SendPrivateMessageToEveryoneWhoTalksRequest) {
		if (input.isAuthorABot) return
		userRepository.getUserById(input.userId)
			?.sendMessage("HEEEELLLOOO :)")
	}
}
