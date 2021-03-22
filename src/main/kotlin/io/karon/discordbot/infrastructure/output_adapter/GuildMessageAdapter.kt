package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.CustomEmote
import io.karon.discordbot.domain.output_port.GuildMessage
import net.dv8tion.jda.api.entities.Message

class GuildMessageAdapter(private val message: Message) : GuildMessage {
	override fun getId() = message.idLong

	override fun addReaction(reactionEmote: CustomEmote) {
		message.addReaction(reactionEmote.getUnicode()).queue()
	}

	override fun addReactions(reactionEmotes: List<CustomEmote>) {
		reactionEmotes.forEach {
			addReaction(it)
		}
	}

	override fun delete() {
		message.delete().queue()
	}
}
