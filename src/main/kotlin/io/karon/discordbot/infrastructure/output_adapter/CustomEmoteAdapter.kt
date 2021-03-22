package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.CustomEmote

class CustomEmoteAdapter(private val unicode: String) : CustomEmote {
	override fun getUnicode() = unicode
}
