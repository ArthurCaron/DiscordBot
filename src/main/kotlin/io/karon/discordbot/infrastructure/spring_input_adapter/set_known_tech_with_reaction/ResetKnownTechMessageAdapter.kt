package io.karon.discordbot.infrastructure.spring_input_adapter.set_known_tech_with_reaction

import io.karon.discordbot.domain.input_port.set_known_tech_with_reaction.ResetKnownTechMessage
import io.karon.discordbot.domain.repository_adapter.EmoteNamesToEmoteUnicodesRepository
import io.karon.discordbot.domain.repository_adapter.KnownTechMessageRepository
import org.springframework.stereotype.Component

@Component
class ResetKnownTechMessageAdapter(
	knownTechMessageRepository: KnownTechMessageRepository,
	emoteNamesToEmoteUnicodesRepository: EmoteNamesToEmoteUnicodesRepository
) : ResetKnownTechMessage(knownTechMessageRepository, emoteNamesToEmoteUnicodesRepository)
