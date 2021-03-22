package io.karon.discordbot.domain.output_port

interface GuildTextChannelPort {
	fun sendMessage(message: String)
	fun sendMessage(message: String, onSuccess: (MessagePort) -> Unit)
	fun asMention(): String
	fun makePrivate()
	fun giveAccessToRole(memberRole: MemberRolePort)
}
