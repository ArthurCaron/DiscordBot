package io.karon.discord_bot.infrastructure.input_adapter.greet_new_member

import io.karon.discord_bot.domain.input_port.greet_new_member.GreetNewMember
import io.karon.discord_bot.domain.repository_port.TextChannelRepository
import org.springframework.stereotype.Component

@Component
class GreetNewMemberAdapter(textChannelRepository: TextChannelRepository) : GreetNewMember(textChannelRepository)
