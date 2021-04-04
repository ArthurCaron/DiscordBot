package io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction

import io.karon.discord_bot.domain.output_port.MemberPort
import io.karon.discord_bot.domain.repository_port.EmoteNamesToRolesRepository
import io.karon.discord_bot.domain.repository_port.KnownTechMessageRepository

open class UpdateRolesOnReaction(
	private val knownTechMessageRepository: KnownTechMessageRepository,
	private val emoteNamesToRolesRepository: EmoteNamesToRolesRepository
) {
	fun reactionAdded(input: Request) {
		if (knownTechMessageRepository.getKnownTechMessage()?.getId() != input.targetedMessageId) return

		emoteNamesToRolesRepository.getRole(input.emoteName)?.let {
			input.member.addRole(it)
		}
	}

	fun reactionRemoved(input: Request) {
		if (knownTechMessageRepository.getKnownTechMessage()?.getId() != input.targetedMessageId) return

		emoteNamesToRolesRepository.getRole(input.emoteName)?.let {
			input.member.removeRole(it)
		}
	}

	data class Request(
		val targetedMessageId: Long,
		val emoteName: String,
		val member: MemberPort
	)
}
