package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.SendPrivateMessageToEveryoneWhoTalks
import io.karon.discordbot.domain.repository_adapter.UserRepository
import org.springframework.stereotype.Component

@Component
class SendPrivateMessageToEveryoneWhoTalksAdapter(userRepository: UserRepository) : SendPrivateMessageToEveryoneWhoTalks(userRepository)
