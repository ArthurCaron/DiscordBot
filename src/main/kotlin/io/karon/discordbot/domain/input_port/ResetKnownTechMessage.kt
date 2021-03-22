package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.ResetKnownTechMessageRequest
import io.karon.discordbot.domain.repository_adapter.EmoteNamesToEmoteUnicodesRepository
import io.karon.discordbot.domain.repository_adapter.KnownTechMessageRepository

open class ResetKnownTechMessage(
	private val knownTechMessageRepository: KnownTechMessageRepository,
	private val emoteNamesToEmoteUnicodesRepository: EmoteNamesToEmoteUnicodesRepository,
) {
	private val knownTechMessage = "Vous pouvez indiquer les technos que vous utilisez"

	fun execute(input: ResetKnownTechMessageRequest) {
		if (input.isAuthorABot) return
		if (input.messageReceived == "!reset_role_setter") {
			input.currentGuildTextChannel.sendMessage(knownTechMessage) { message ->
				knownTechMessageRepository.getKnownTechMessage()?.delete()
				knownTechMessageRepository.setKnownTechMessage(message)
				val expectedReactions = emoteNamesToEmoteUnicodesRepository.getCustomEmotes("auyellow", "augreen", "fire")
				message.addReactions(expectedReactions)
			}
		}
	}
}
