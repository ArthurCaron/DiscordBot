package io.karon.discordbot.domain.output_port

interface UserPrivateChannel {
	fun sendMessage(message: String)
}
