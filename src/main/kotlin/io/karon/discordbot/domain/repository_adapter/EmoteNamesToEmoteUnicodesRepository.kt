package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.CustomEmote

interface EmoteNamesToEmoteUnicodesRepository {
	fun getCustomEmotes(vararg emoteNames: String): List<CustomEmote>
}
