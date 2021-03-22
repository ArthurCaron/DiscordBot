package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.JoinPrivateThreadOnReactionRequest
import io.karon.discordbot.domain.repository_adapter.PrivateThreadRepository

open class JoinPrivateThreadOnReaction(private val privateThreadRepository: PrivateThreadRepository) {
	fun execute(input: JoinPrivateThreadOnReactionRequest) {
		privateThreadRepository.getByMessageId(input.targetedMessageId)?.let { privateThread ->
			input.memberUser.addRole(privateThread.memberRole)
		}
	}
}
