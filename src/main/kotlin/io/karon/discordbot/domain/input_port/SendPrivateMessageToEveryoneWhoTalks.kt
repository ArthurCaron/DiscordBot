package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.SendPrivateMessageToEveryoneWhoTalksRequest
import io.karon.discordbot.domain.repository_adapter.UserRepository

open class SendPrivateMessageToEveryoneWhoTalks(private val userRepository: UserRepository) {
	fun execute(input: SendPrivateMessageToEveryoneWhoTalksRequest) {
		if (input.isAuthorABot) return
		userRepository.getUserById(input.userId)
			?.sendMessage("HEEEELLLOOO :)")
	}
}
