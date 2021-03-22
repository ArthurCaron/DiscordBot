package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.ResetKnownTechMessage
import io.karon.discordbot.domain.repository_adapter.EmoteNamesToEmoteUnicodesRepository
import io.karon.discordbot.domain.repository_adapter.KnownTechMessageRepository
import org.springframework.stereotype.Component

@Component
class ResetKnownTechMessageAdapter(
	knownTechMessageRepository: KnownTechMessageRepository,
	emoteNamesToEmoteUnicodesRepository: EmoteNamesToEmoteUnicodesRepository
) : ResetKnownTechMessage(knownTechMessageRepository, emoteNamesToEmoteUnicodesRepository)
