package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.UserPrivateChannelPort
import io.karon.discord_bot.domain.repository_adapter.UserRepository
import io.karon.discord_bot.infrastructure.output_adapter.UserPrivateChannelAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(private val jda: JDA) : UserRepository {
	override fun getUserById(userId: String): UserPrivateChannelPort? {
		return jda.getUserById(userId)?.let {
			UserPrivateChannelAdapter(it)
		}
	}
}
