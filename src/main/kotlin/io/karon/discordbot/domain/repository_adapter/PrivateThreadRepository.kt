package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.input_port.PrivateThread

interface PrivateThreadRepository {
	fun registerPrivateThread(privateThread: PrivateThread)
	fun getByMessageId(targetedMessageId: Long): PrivateThread?
}
