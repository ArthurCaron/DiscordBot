package io.karon.discord_bot.domain.output_port

interface UserPrivateChannelPort {
	fun sendMessage(message: String)
}
