package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.input_port.dynamic_private_thread.PrivateThread
import io.karon.discordbot.domain.repository_adapter.PrivateThreadRepository
import org.springframework.stereotype.Component

@Component
class PrivateThreadRepositoryAdapter : PrivateThreadRepository {
	private val privateThreads = mutableMapOf<Long, PrivateThread>()

	override fun savePrivateThread(privateThread: PrivateThread) {
		privateThreads[privateThread.message.getId()] = privateThread
	}

	override fun getByMessageId(targetedMessageId: Long) = privateThreads[targetedMessageId]
}
