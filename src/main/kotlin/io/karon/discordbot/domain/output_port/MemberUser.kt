package io.karon.discordbot.domain.output_port

interface MemberUser {
	fun addRole(memberRole: MemberRole)
	fun removeRole(memberRole: MemberRole)
}
