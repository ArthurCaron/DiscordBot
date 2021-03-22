package io.karon.discord_bot.domain.repository_adapter

import io.karon.discord_bot.domain.output_port.EmotePort

interface EmoteNamesToEmoteUnicodesRepository {
	fun getCustomEmotes(vararg emoteNames: String): List<EmotePort>
}
