package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.GuildMessage

interface KnownTechMessageRepository {
	fun getKnownTechMessage(): GuildMessage?
	fun setKnownTechMessage(message: GuildMessage)
}
