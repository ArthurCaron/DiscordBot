package io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction

import io.karon.discord_bot.domain.output_port.MemberPort

data class UpdateRolesOnReactionRequest(
	val targetedMessageId: Long,
	val emoteName: String,
	val member: MemberPort
)
