package io.karon.discordbot.infrastructure.spring_input_adapter.dynamic_private_thread

import io.karon.discordbot.domain.input_port.dynamic_private_thread.JoinPrivateThreadOnReaction
import io.karon.discordbot.infrastructure.repository_adapter.PrivateThreadRepositoryAdapter
import org.springframework.stereotype.Component

@Component
class JoinPrivateThreadOnReactionAdapter(
	privateThreadRepositoryAdapter: PrivateThreadRepositoryAdapter
) : JoinPrivateThreadOnReaction(privateThreadRepositoryAdapter)
