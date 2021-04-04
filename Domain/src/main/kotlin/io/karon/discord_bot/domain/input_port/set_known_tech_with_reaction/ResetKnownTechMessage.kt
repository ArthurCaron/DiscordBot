package io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.repository_port.EmoteNamesToEmoteUnicodesRepository
import io.karon.discord_bot.domain.repository_port.KnownTechMessageRepository

open class ResetKnownTechMessage(
	private val knownTechMessageRepository: KnownTechMessageRepository,
	private val emoteNamesToEmoteUnicodesRepository: EmoteNamesToEmoteUnicodesRepository,
) {
	private val knownTechMessage = "Vous pouvez indiquer les technos que vous utilisez"

	suspend fun execute(input: Request) {
		if (input.isAuthorABot) return
		if (input.messageReceived == "!reset_role_setter") {
			val message = input.currentGuildTextChannel.sendMessage(knownTechMessage) ?: return
			knownTechMessageRepository.getKnownTechMessage()?.delete()
			knownTechMessageRepository.setKnownTechMessage(message)
			val expectedReactions = emoteNamesToEmoteUnicodesRepository.getCustomEmotes("auyellow", "augreen", "fire")
			message.addReactions(expectedReactions)
		}
	}

	data class Request(
		val isAuthorABot: Boolean,
		val messageReceived: String,
		val currentGuildTextChannel: GuildTextChannelPort
	)
}
