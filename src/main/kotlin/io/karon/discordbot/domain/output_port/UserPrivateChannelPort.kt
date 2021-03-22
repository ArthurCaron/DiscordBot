package io.karon.discordbot.domain.output_port

interface UserPrivateChannelPort {
	fun sendMessage(message: String)
}
