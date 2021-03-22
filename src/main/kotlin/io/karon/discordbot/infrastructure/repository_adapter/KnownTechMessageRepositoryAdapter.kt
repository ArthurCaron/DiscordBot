package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.output_port.GuildMessage
import io.karon.discordbot.domain.repository_adapter.KnownTechMessageRepository
import org.springframework.stereotype.Component

@Component
class KnownTechMessageRepositoryAdapter : KnownTechMessageRepository {
	private var knownTechMessage: GuildMessage? = null

	override fun getKnownTechMessage(): GuildMessage? {
		return knownTechMessage
	}

	override fun setKnownTechMessage(message: GuildMessage) {
		knownTechMessage = message
	}
}
