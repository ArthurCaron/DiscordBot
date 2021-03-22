package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.output_port.UserPrivateChannel
import io.karon.discordbot.domain.repository_adapter.UserRepository
import io.karon.discordbot.infrastructure.output_adapter.UserPrivateChannelAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(private val jda: JDA) : UserRepository {
	override fun getUserById(userId: String): UserPrivateChannel? {
		return jda.getUserById(userId)?.let {
			UserPrivateChannelAdapter(it)
		}
	}
}
