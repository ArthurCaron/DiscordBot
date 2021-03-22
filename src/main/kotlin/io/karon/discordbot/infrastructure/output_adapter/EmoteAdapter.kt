package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.EmotePort

class EmoteAdapter(private val unicode: String) : EmotePort {
	override fun getUnicode() = unicode
}
