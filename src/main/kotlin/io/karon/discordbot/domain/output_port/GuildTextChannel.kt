package io.karon.discordbot.domain.output_port

interface GuildTextChannel {
	fun sendMessage(message: String)
	fun sendMessage(message: String, onSuccess: (GuildMessage) -> Unit)
	fun asMention(): String
	fun makePrivate()
	fun giveAccessToRole(memberRole: MemberRole)
}
