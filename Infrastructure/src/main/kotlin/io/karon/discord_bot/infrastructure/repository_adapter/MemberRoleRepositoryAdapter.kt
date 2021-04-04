package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.MemberRolePort
import io.karon.discord_bot.domain.repository_port.MemberRoleRepository
import io.karon.discord_bot.infrastructure.output_adapter.MemberRoleAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class MemberRoleRepositoryAdapter(private val jda: JDA) : MemberRoleRepository {
	override suspend fun createRole(guildId: Long, name: String): MemberRolePort? {
		return jda.getGuildById(guildId)
			?.createRole()
			?.setName(name)
			?.awaitCallback()
			?.let { MemberRoleAdapter(it.idLong) }
	}
}
