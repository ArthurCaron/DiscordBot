package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.MemberRolePort

interface EmoteNamesToRolesRepository {
	fun getRole(emoteName: String): MemberRolePort?
}
