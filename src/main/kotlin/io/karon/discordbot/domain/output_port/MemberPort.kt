package io.karon.discordbot.domain.output_port

interface MemberPort {
	fun addRole(memberRole: MemberRolePort)
	fun removeRole(memberRole: MemberRolePort)
}
