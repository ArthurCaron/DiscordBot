package io.karon.discordbot.domain.api

import io.karon.discordbot.domain.output_port.MemberUser

data class UpdateRolesOnReactionRequest(
	val targetedMessageId: Long,
	val emoteName: String,
	val memberUser: MemberUser
)
