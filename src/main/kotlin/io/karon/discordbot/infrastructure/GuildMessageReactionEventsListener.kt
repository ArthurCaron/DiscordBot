package io.karon.discordbot.infrastructure

import io.karon.discordbot.domain.api.JoinPrivateThreadOnReactionRequest
import io.karon.discordbot.domain.api.UpdateRolesOnReactionRequest
import io.karon.discordbot.infrastructure.output_adapter.MemberUserAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.UpdateRolesOnReactionAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.JoinPrivateThreadOnReactionAdapter
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
				MemberUserAdapter(event.member)
			)
		)

		joinPrivateThreadOnReactionAdapter.execute(
			JoinPrivateThreadOnReactionRequest(
				event.messageIdLong,
				MemberUserAdapter(event.member)
			)
		)
	}

	override fun onGuildMessageReactionRemove(event: GuildMessageReactionRemoveEvent) {
		updateRolesOnReactionAdapter.reactionRemoved(
			UpdateRolesOnReactionRequest(
				event.messageIdLong,
				event.reactionEmote.name,
				MemberUserAdapter(event.retrieveMember().complete())
			)
		)
	}
}
