package io.karon.discordbot.infrastructure

import io.karon.discordbot.domain.input_port.dynamic_private_thread.JoinPrivateThreadOnReactionRequest
import io.karon.discordbot.domain.input_port.set_known_tech_with_reaction.UpdateRolesOnReactionRequest
import io.karon.discordbot.infrastructure.output_adapter.MemberAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.set_known_tech_with_reaction.UpdateRolesOnReactionAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.dynamic_private_thread.JoinPrivateThreadOnReactionAdapter
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.stereotype.Component
import java.util.*

@Component
final class GuildMessageReactionEventsListener(
	jda: JDA,
	private val updateRolesOnReactionAdapter: UpdateRolesOnReactionAdapter,
	private val joinPrivateThreadOnReactionAdapter: JoinPrivateThreadOnReactionAdapter
) : ListenerAdapter() {
	companion object {
		fun getGatewayIntents(): EnumSet<GatewayIntent> {
			return GatewayIntent.fromEvents(
				GuildMessageReactionAddEvent::class.java,
				GuildMessageReactionRemoveEvent::class.java,
			)
		}
	}

	init {
		jda.addEventListener(this)
	}

	override fun onGuildMessageReactionAdd(event: GuildMessageReactionAddEvent) {
		updateRolesOnReactionAdapter.reactionAdded(
			UpdateRolesOnReactionRequest(
				event.messageIdLong,
				event.reactionEmote.name,
				MemberAdapter(event.member)
			)
		)

		joinPrivateThreadOnReactionAdapter.execute(
			JoinPrivateThreadOnReactionRequest(
				event.messageIdLong,
				MemberAdapter(event.member)
			)
		)
	}

	override fun onGuildMessageReactionRemove(event: GuildMessageReactionRemoveEvent) {
		updateRolesOnReactionAdapter.reactionRemoved(
			UpdateRolesOnReactionRequest(
				event.messageIdLong,
				event.reactionEmote.name,
				MemberAdapter(event.retrieveMember().complete())
			)
		)
	}
}
