package io.karon.discord_bot.domain.repository_adapter

import io.karon.discord_bot.domain.input_port.dynamic_private_thread.PrivateThread

interface PrivateThreadRepository {
	fun savePrivateThread(privateThread: PrivateThread)
	fun getByMessageId(targetedMessageId: Long): PrivateThread?
}
