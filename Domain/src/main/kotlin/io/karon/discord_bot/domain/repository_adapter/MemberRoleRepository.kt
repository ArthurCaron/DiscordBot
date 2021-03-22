package io.karon.discord_bot.domain.repository_adapter

import io.karon.discord_bot.domain.output_port.MemberRolePort

interface MemberRoleRepository {
	fun createRole(guildId: Long, name: String, onSuccess: (MemberRolePort) -> Unit)
}
