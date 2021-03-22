package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.MemberRolePort

interface MemberRoleRepository {
	fun createRole(guildId: Long, name: String, onSuccess: (MemberRolePort) -> Unit)
}
