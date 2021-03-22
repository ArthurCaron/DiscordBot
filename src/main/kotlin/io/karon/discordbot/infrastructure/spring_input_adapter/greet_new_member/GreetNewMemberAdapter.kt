package io.karon.discordbot.infrastructure.spring_input_adapter.greet_new_member

import io.karon.discordbot.domain.input_port.greet_new_member.GreetNewMember
import io.karon.discordbot.domain.repository_adapter.TextChannelRepository
import org.springframework.stereotype.Component

@Component
class GreetNewMemberAdapter(textChannelRepository: TextChannelRepository) : GreetNewMember(textChannelRepository)
