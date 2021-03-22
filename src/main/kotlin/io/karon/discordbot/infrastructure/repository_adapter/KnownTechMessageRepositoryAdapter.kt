package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.output_port.MessagePort
import io.karon.discordbot.domain.repository_adapter.KnownTechMessageRepository
import org.springframework.stereotype.Component

@Component
class KnownTechMessageRepositoryAdapter : KnownTechMessageRepository {
	private var knownTechMessage: MessagePort? = null

	override fun getKnownTechMessage(): MessagePort? {
		return knownTechMessage
	}

	override fun setKnownTechMessage(message: MessagePort) {
		knownTechMessage = message
	}
}
