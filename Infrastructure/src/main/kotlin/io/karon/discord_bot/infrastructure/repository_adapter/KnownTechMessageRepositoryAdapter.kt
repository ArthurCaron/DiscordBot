package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.MessagePort
import io.karon.discord_bot.domain.repository_port.KnownTechMessageRepository
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
