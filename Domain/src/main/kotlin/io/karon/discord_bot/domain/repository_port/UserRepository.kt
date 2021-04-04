package io.karon.discord_bot.domain.repository_port

import io.karon.discord_bot.domain.output_port.UserPrivateChannelPort

interface UserRepository {
	fun getUserById(userId: String): UserPrivateChannelPort?
}
