package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.output_port.MemberRolePort
import io.karon.discordbot.domain.repository_adapter.EmoteNamesToRolesRepository
import io.karon.discordbot.infrastructure.output_adapter.MemberRoleAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class EmoteNamesToRolesRepositoryAdapter(private val jda: JDA) : EmoteNamesToRolesRepository {
	private val emoteNamesToRoleNames = mapOf(
		"auyellow" to "Java",
		"augreen" to "bot_tester",
	)
	private val roleNamesToId = mapOf(
		"Java" to 823285873109237810,
		"bot_tester" to 823285911261151332,
	)

	override fun getRole(emoteName: String): MemberRolePort? {
//		return jda.getRolesByName("Java", false)
//			.mapNotNull { MemberRoleAdapter(it) }
//			.firstOrNull()
		// could then create role
		// maybe somewhere else
		return emoteNamesToRoleNames[emoteName]?.let { roleName ->
			roleNamesToId[roleName]?.let { roleId ->
				MemberRoleAdapter(roleId)
			}
		}
	}
}
