package io.karon.discordbot.domain.input_port.send_private_message_when_someone_speaks

data class SendPrivateMessageToEveryoneWhoTalksRequest(
	val isAuthorABot: Boolean,
	val userId: String
)
