package io.karon.discord_bot.infrastructure.repository_adapter

import io.karon.discord_bot.domain.output_port.MemberRolePort
import io.karon.discord_bot.domain.repository_adapter.MemberRoleRepository
import io.karon.discord_bot.infrastructure.output_adapter.MemberRoleAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class MemberRoleRepositoryAdapter(private val jda: JDA) : MemberRoleRepository {
	override fun createRole(guildId: Long, name: String, onSuccess: (MemberRolePort) -> Unit) {
		jda.getGuildById(guildId)?.createRole()?.setName(name)?.queue {
			onSuccess(MemberRoleAdapter(it.idLong))
		}
	}
}
