package io.karon.discordbot.domain.input_port.dynamic_private_thread

import io.karon.discordbot.domain.output_port.MemberPort

data class JoinPrivateThreadOnReactionRequest(
	val targetedMessageId: Long,
	val member: MemberPort
)
