package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.input_port.dynamic_private_thread.PrivateThread

interface PrivateThreadRepository {
	fun savePrivateThread(privateThread: PrivateThread)
	fun getByMessageId(targetedMessageId: Long): PrivateThread?
}
