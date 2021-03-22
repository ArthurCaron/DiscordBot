package io.karon.discord_bot.domain.output_port

interface MemberPort {
	fun addRole(memberRole: MemberRolePort)
	fun removeRole(memberRole: MemberRolePort)
}
