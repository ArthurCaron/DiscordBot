package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.UpdateRolesOnReaction
import io.karon.discordbot.infrastructure.repository_adapter.EmoteNamesToRolesRepositoryAdapter
import io.karon.discordbot.infrastructure.repository_adapter.KnownTechMessageRepositoryAdapter
import org.springframework.stereotype.Component

@Component
class UpdateRolesOnReactionAdapter(
	knownTechMessageRepositoryAdapter: KnownTechMessageRepositoryAdapter,
	emoteNamesToRolesRepositoryAdapter: EmoteNamesToRolesRepositoryAdapter
) : UpdateRolesOnReaction(knownTechMessageRepositoryAdapter, emoteNamesToRolesRepositoryAdapter)
