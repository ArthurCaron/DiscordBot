package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.output_port.EmotePort
import io.karon.discordbot.domain.repository_adapter.EmoteNamesToEmoteUnicodesRepository
import io.karon.discordbot.infrastructure.output_adapter.EmoteAdapter
import org.springframework.stereotype.Component

@Component
class EmoteNamesToEmoteUnicodesRepositoryAdapter : EmoteNamesToEmoteUnicodesRepository {
	private val customEmotes = mapOf(
		"auyellow" to "auyellow:772484959268896768",
		"augreen" to "augreen:772484955783168040",
	)
	private val standardEmotes = mapOf(
		"fire" to "\uD83D\uDD25",
	)

	override fun getCustomEmotes(vararg emoteNames: String): List<EmotePort> {
		// Can't make this work
//		val emoteById = jda.getEmoteById(772484959268896768)
//		val emote2 = jda.getEmoteById("772484959268896768")
//		val emote3 = jda.getEmotesByName("auyellow", true)
//		val emote4 = jda.getEmotesByName(":auyellow:", true)
//		val emote5 = jda.getEmotesByName("auyellow", false)
//		val emote6 = jda.getEmotesByName(":auyellow:", false)
//		val map = emoteNames.map { jda.getEmotesByName(it, false) }
//			.mapNotNull { it.firstOrNull() }
//			.map { CustomEmoteAdapter(it.name, it.id) }


		return emoteNames.mapNotNull { name ->
			(customEmotes[name] ?: standardEmotes[name])?.let { unicode ->
				EmoteAdapter(unicode)
			}
		}
	}
}
