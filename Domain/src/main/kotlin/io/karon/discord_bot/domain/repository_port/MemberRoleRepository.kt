package io.karon.discord_bot.domain.repository_port

import io.karon.discord_bot.domain.output_port.MemberRolePort

interface MemberRoleRepository {
	suspend fun createRole(guildId: Long, name: String): MemberRolePort?
}
