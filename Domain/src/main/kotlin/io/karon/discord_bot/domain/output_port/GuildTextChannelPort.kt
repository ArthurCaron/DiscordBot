package io.karon.discord_bot.domain.output_port

interface GuildTextChannelPort {
	suspend fun sendMessage(message: String): MessagePort?
	fun asMention(): String
	fun makePrivate()
	fun giveAccessToRole(memberRole: MemberRolePort)
}
