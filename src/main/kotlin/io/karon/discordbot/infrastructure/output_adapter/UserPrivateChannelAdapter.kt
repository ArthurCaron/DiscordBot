package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.UserPrivateChannel
import net.dv8tion.jda.api.entities.User

class UserPrivateChannelAdapter(private val user: User) : UserPrivateChannel {
	override fun sendMessage(message: String) {
		user.openPrivateChannel().queue {
			it.sendMessage(message).queue()
		}
	}
}
