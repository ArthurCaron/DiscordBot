package io.karon.discordbot.domain.repository_adapter

import io.karon.discordbot.domain.output_port.MemberRole

interface EmoteNamesToRolesRepository {
	fun getRole(emoteName: String): MemberRole?
}
