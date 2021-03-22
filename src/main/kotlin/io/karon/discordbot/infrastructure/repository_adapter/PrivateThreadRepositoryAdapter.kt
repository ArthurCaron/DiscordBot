package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.input_port.PrivateThread
import io.karon.discordbot.domain.repository_adapter.PrivateThreadRepository
import org.springframework.stereotype.Component

@Component
class PrivateThreadRepositoryAdapter : PrivateThreadRepository {
	private val privateThreads = mutableMapOf<Long, PrivateThread>()

	override fun registerPrivateThread(privateThread: PrivateThread) {
		privateThreads[privateThread.guildMessage.getId()] = privateThread
	}

	override fun getByMessageId(targetedMessageId: Long) = privateThreads[targetedMessageId]
}
