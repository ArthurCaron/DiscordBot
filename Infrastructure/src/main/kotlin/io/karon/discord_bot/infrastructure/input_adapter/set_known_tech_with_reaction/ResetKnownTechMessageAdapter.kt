package io.karon.discord_bot.infrastructure.input_adapter.set_known_tech_with_reaction

import io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction.ResetKnownTechMessage
import io.karon.discord_bot.domain.repository_port.EmoteNamesToEmoteUnicodesRepository
import io.karon.discord_bot.domain.repository_port.KnownTechMessageRepository
import org.springframework.stereotype.Component

@Component
class ResetKnownTechMessageAdapter(
	knownTechMessageRepository: KnownTechMessageRepository,
	emoteNamesToEmoteUnicodesRepository: EmoteNamesToEmoteUnicodesRepository
) : ResetKnownTechMessage(knownTechMessageRepository, emoteNamesToEmoteUnicodesRepository)
