package io.karon.discord_bot.domain.repository_adapter

import io.karon.discord_bot.domain.output_port.MemberRolePort

interface EmoteNamesToRolesRepository {
	fun getRole(emoteName: String): MemberRolePort?
}
