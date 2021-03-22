package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.UserPrivateChannelPort

interface UserRepository {
	fun getUserById(userId: String): UserPrivateChannelPort?
}
