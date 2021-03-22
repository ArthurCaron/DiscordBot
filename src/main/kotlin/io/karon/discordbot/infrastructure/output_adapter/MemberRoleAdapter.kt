package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.MemberRole

class MemberRoleAdapter(private val roleId: Long) : MemberRole { // TODO should take the role instead of the roleId
	override fun getRoleId() = roleId
}
