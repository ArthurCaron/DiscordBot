package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.MessagePort

interface KnownTechMessageRepository {
	fun getKnownTechMessage(): MessagePort?
	fun setKnownTechMessage(message: MessagePort)
}
