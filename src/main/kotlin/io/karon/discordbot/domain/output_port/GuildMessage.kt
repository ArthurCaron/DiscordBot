package io.karon.discordbot.domain.output_port

interface GuildMessage {
	fun getId(): Long
	fun addReaction(reactionEmote: CustomEmote)
	fun addReactions(reactionEmotes: List<CustomEmote>)
	fun delete()
}
