package io.karon.discordbot.domain.output_port

interface MessagePort {
	fun getId(): Long
	fun addReaction(reactionEmote: EmotePort)
	fun addReactions(reactionEmotes: List<EmotePort>)
	fun delete()
}
