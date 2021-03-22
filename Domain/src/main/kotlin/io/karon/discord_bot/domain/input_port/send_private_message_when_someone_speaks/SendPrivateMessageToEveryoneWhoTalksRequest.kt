package io.karon.discord_bot.domain.input_port.send_private_message_when_someone_speaks

data class SendPrivateMessageToEveryoneWhoTalksRequest(
	val isAuthorABot: Boolean,
	val userId: String
)
