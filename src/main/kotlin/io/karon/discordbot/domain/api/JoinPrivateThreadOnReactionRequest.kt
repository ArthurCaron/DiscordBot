package io.karon.discordbot.domain.api

import io.karon.discordbot.domain.output_port.MemberUser

data class JoinPrivateThreadOnReactionRequest(
	val targetedMessageId: Long,
	val memberUser: MemberUser
)
