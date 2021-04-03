package io.karon.discord_bot.infrastructure.output_adapter

import io.karon.discord_bot.domain.output_port.MemberPort
import io.karon.discord_bot.domain.output_port.MemberRolePort
import net.dv8tion.jda.api.entities.Member

class MemberAdapter(private val member: Member) : MemberPort {
	override fun addRole(memberRole: MemberRolePort) {
		member.guild.getRoleById(memberRole.getRoleId())?.let {
			member.guild.addRoleToMember(member.user.id, it).queue()
		}
	}

	override fun removeRole(memberRole: MemberRolePort) {
		member.guild.getRoleById(memberRole.getRoleId())?.let {
			member.guild.removeRoleFromMember(member.user.id, it).queue()
		}
	}
}
