package io.karon.discord_bot.infrastructure.input_adapter.dynamic_private_thread

import io.karon.discord_bot.domain.input_port.dynamic_private_thread.CreateDynamicPrivateChannel
import io.karon.discord_bot.infrastructure.repository_adapter.MemberRoleRepositoryAdapter
import io.karon.discord_bot.infrastructure.repository_adapter.PrivateThreadRepositoryAdapter
import io.karon.discord_bot.infrastructure.repository_adapter.TextChannelRepositoryAdapter
import org.springframework.stereotype.Component

@Component
class CreateDynamicPrivateChannelAdapter(
	textChannelRepositoryAdapter: TextChannelRepositoryAdapter,
	memberRoleRepositoryAdapter: MemberRoleRepositoryAdapter,
	privateThreadRepositoryAdapter: PrivateThreadRepositoryAdapter
) : CreateDynamicPrivateChannel(
	textChannelRepositoryAdapter,
	memberRoleRepositoryAdapter,
	privateThreadRepositoryAdapter
)
