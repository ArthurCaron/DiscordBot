package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.MemberRolePort
import io.karon.discord_bot.domain.repository_adapter.EmoteNamesToRolesRepository
import io.karon.discord_bot.infrastructure.output_adapter.MemberRoleAdapter
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
	).mapValues { MemberRoleAdapter(it.value) }

	override fun getRole(emoteName: String): MemberRolePort? {
//		return jda.getRolesByName("Java", false)
//			.mapNotNull { MemberRoleAdapter(it) }
//			.firstOrNull()
		// could then create role
		// maybe somewhere else
		return emoteNamesToRoleNames[emoteName]?.let { roleNamesToId[it] }
	}
}
