package io.karon.discord_bot.infrastructure.spring_input_adapter.greet_new_member

import io.karon.discord_bot.domain.input_port.greet_new_member.GreetNewMember
import io.karon.discord_bot.domain.repository_adapter.TextChannelRepository
import org.springframework.stereotype.Component

@Component
class GreetNewMemberAdapter(textChannelRepository: TextChannelRepository) : GreetNewMember(textChannelRepository)
