package io.karon.discord_bot.infrastructure.input_adapter.send_private_message_when_someone_speaks

import io.karon.discord_bot.domain.input_port.send_private_message_when_someone_speaks.SendPrivateMessageToEveryoneWhoTalks
import io.karon.discord_bot.domain.repository_port.UserRepository
import org.springframework.stereotype.Component

@Component
class SendPrivateMessageToEveryoneWhoTalksAdapter(userRepository: UserRepository) : SendPrivateMessageToEveryoneWhoTalks(userRepository)
