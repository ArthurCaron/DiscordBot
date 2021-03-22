package io.karon.discord_bot.infrastructure.output_adapter

import io.karon.discord_bot.domain.output_port.UserPrivateChannelPort
import net.dv8tion.jda.api.entities.User

class UserPrivateChannelAdapter(private val user: User) : UserPrivateChannelPort {
	override fun sendMessage(message: String) {
		user.openPrivateChannel().queue {
			it.sendMessage(message).queue()
		}
	}
}
