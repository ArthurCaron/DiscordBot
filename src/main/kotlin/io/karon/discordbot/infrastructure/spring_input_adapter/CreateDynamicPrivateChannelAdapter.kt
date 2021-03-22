package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.CreateDynamicPrivateChannel
import io.karon.discordbot.infrastructure.repository_adapter.MemberRoleRepositoryAdapter
import io.karon.discordbot.infrastructure.repository_adapter.PrivateThreadRepositoryAdapter
import io.karon.discordbot.infrastructure.repository_adapter.TextChannelRepositoryAdapter
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
