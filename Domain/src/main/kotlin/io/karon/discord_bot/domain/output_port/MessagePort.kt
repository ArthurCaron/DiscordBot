package io.karon.discord_bot.domain.output_port

interface MessagePort {
	fun getId(): Long
	fun addReaction(reactionEmote: EmotePort)
	fun addReactions(reactionEmotes: List<EmotePort>)
	fun delete()
}
