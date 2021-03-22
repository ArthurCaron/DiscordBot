package io.karon.discordbot.domain.input_port.dynamic_private_thread

import io.karon.discordbot.domain.repository_adapter.PrivateThreadRepository

open class JoinPrivateThreadOnReaction(private val privateThreadRepository: PrivateThreadRepository) {
	fun execute(input: JoinPrivateThreadOnReactionRequest) {
		privateThreadRepository.getByMessageId(input.targetedMessageId)?.let { privateThread ->
			input.member.addRole(privateThread.memberRole)
		}
	}
}
