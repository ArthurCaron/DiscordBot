package io.karon.discordbot.domain.input_port.set_known_tech_with_reaction

import io.karon.discordbot.domain.output_port.MemberPort

data class UpdateRolesOnReactionRequest(
	val targetedMessageId: Long,
	val emoteName: String,
	val member: MemberPort
)
