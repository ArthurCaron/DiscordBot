package io.karon.discord_bot.domain.input_port.dynamic_private_thread

import io.karon.discord_bot.domain.output_port.MemberPort

data class JoinPrivateThreadOnReactionRequest(
	val targetedMessageId: Long,
	val member: MemberPort
)
