package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.UpdateRolesOnReactionRequest
import io.karon.discordbot.domain.repository_adapter.EmoteNamesToRolesRepository
import io.karon.discordbot.domain.repository_adapter.KnownTechMessageRepository

open class UpdateRolesOnReaction(
	private val knownTechMessageRepository: KnownTechMessageRepository,
	private val emoteNamesToRolesRepository: EmoteNamesToRolesRepository
) {
	fun reactionAdded(input: UpdateRolesOnReactionRequest) {
		if (knownTechMessageRepository.getKnownTechMessage()?.getId() != input.targetedMessageId) return

		emoteNamesToRolesRepository.getRole(input.emoteName)?.let {
			input.memberUser.addRole(it)
		}
	}

	fun reactionRemoved(input: UpdateRolesOnReactionRequest) {
		if (knownTechMessageRepository.getKnownTechMessage()?.getId() != input.targetedMessageId) return

		emoteNamesToRolesRepository.getRole(input.emoteName)?.let {
			input.memberUser.removeRole(it)
		}
	}
}
