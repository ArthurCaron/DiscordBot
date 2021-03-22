package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.GreetNewMember
import io.karon.discordbot.domain.repository_adapter.TextChannelRepository
import org.springframework.stereotype.Component

@Component
class GreetNewMemberAdapter(textChannelRepository: TextChannelRepository) : GreetNewMember(textChannelRepository)
