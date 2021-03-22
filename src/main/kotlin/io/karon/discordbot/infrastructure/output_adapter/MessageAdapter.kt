package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.EmotePort
import io.karon.discordbot.domain.output_port.MessagePort
import net.dv8tion.jda.api.entities.Message

class MessageAdapter(private val message: Message) : MessagePort {
	override fun getId() = message.idLong

	override fun addReaction(reactionEmote: EmotePort) {
		message.addReaction(reactionEmote.getUnicode()).queue()
	}

	override fun addReactions(reactionEmotes: List<EmotePort>) {
		reactionEmotes.forEach {
			addReaction(it)
		}
	}

	override fun delete() {
		message.delete().queue()
	}
}
