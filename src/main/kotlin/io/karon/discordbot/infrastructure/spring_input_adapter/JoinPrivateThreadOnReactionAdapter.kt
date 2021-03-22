package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.JoinPrivateThreadOnReaction
import io.karon.discordbot.infrastructure.repository_adapter.PrivateThreadRepositoryAdapter
import org.springframework.stereotype.Component

@Component
class JoinPrivateThreadOnReactionAdapter(
	privateThreadRepositoryAdapter: PrivateThreadRepositoryAdapter
) : JoinPrivateThreadOnReaction(privateThreadRepositoryAdapter)
