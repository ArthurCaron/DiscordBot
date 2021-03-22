package io.karon.discord_bot.infrastructure.spring_input_adapter.dynamic_private_thread

import io.karon.discord_bot.domain.input_port.dynamic_private_thread.JoinPrivateThreadOnReaction
import io.karon.discord_bot.infrastructure.repository_adapter.PrivateThreadRepositoryAdapter
import org.springframework.stereotype.Component

@Component
class JoinPrivateThreadOnReactionAdapter(
	privateThreadRepositoryAdapter: PrivateThreadRepositoryAdapter
) : JoinPrivateThreadOnReaction(privateThreadRepositoryAdapter)
