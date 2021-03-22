package io.karon.discord_bot.infrastructure.output_adapter

import io.karon.discord_bot.domain.output_port.EmotePort

class EmoteAdapter(private val unicode: String) : EmotePort {
	override fun getUnicode() = unicode
}
