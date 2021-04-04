package io.karon.discord_bot.domain.input_port.dynamic_private_thread

import io.karon.discord_bot.domain.output_port.MemberPort
import io.karon.discord_bot.domain.repository_port.PrivateThreadRepository

open class JoinPrivateThreadOnReaction(private val privateThreadRepository: PrivateThreadRepository) {
	fun execute(input: Request) {
		privateThreadRepository.getByMessageId(input.targetedMessageId)?.let { privateThread ->
			input.member.addRole(privateThread.memberRole)
		}
	}

	data class Request(
		val targetedMessageId: Long,
		val member: MemberPort
	)
}
