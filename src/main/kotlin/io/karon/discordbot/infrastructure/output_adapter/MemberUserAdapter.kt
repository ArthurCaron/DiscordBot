package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.MemberRole
import io.karon.discordbot.domain.output_port.MemberUser
import net.dv8tion.jda.api.entities.Member

class MemberUserAdapter(private val member: Member) : MemberUser {
	override fun addRole(memberRole: MemberRole) {
		member.guild.getRoleById(memberRole.getRoleId())?.let {
			member.guild.addRoleToMember(member.user.id, it).queue()
		}
	}

	override fun removeRole(memberRole: MemberRole) {
		member.guild.getRoleById(memberRole.getRoleId())?.let {
			member.guild.removeRoleFromMember(member.user.id, it).queue()
		}
	}
}
