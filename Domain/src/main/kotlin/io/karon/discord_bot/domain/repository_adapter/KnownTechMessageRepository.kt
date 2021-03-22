package io.karon.discord_bot.domain.repository_adapter

import io.karon.discord_bot.domain.output_port.MessagePort

interface KnownTechMessageRepository {
	fun getKnownTechMessage(): MessagePort?
	fun setKnownTechMessage(message: MessagePort)
}
