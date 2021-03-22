package io.karon.discordbot.infrastructure.spring_input_adapter

import io.karon.discordbot.domain.input_port.AnswerPongToPing
import org.springframework.stereotype.Component

@Component
class AnswerPongToPingAdapter : AnswerPongToPing()
