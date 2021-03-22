package io.karon.discordbot.domain.api

data class SendPrivateMessageToEveryoneWhoTalksRequest(
	val isAuthorABot: Boolean,
	val userId: String
)
