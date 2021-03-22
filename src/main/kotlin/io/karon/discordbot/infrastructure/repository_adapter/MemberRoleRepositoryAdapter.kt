package io.karon.discordbot.infrastructure.repository_adapter

import io.karon.discordbot.domain.output_port.MemberRole
import io.karon.discordbot.domain.repository_adapter.MemberRoleRepository
import io.karon.discordbot.infrastructure.output_adapter.MemberRoleAdapter
import net.dv8tion.jda.api.JDA
import org.springframework.stereotype.Component

@Component
class MemberRoleRepositoryAdapter(private val jda: JDA) : MemberRoleRepository {
	override fun createRole(guildId: Long, name: String, onSuccess: (MemberRole) -> Unit) {
		jda.getGuildById(guildId)?.createRole()?.setName(name)?.queue {
			onSuccess(MemberRoleAdapter(it.idLong))
		}
	}
}
