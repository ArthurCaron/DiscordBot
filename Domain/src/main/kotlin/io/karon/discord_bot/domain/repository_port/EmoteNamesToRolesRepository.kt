package io.karon.discord_bot.domain.repository_port

import io.karon.discord_bot.domain.output_port.MemberRolePort

interface EmoteNamesToRolesRepository {
	fun getRole(emoteName: String): MemberRolePort?
}
