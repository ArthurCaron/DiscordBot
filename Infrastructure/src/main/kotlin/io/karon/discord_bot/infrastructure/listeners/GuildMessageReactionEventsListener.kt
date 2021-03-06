package io.karon.discord_bot.infrastructure.listeners

import io.karon.discord_bot.domain.input_port.dynamic_private_thread.JoinPrivateThreadOnReaction
import io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction.UpdateRolesOnReaction
import io.karon.discord_bot.infrastructure.output_adapter.MemberAdapter
import kotlinx.coroutines.runBlocking
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
	private val updateRolesOnReaction: UpdateRolesOnReaction,
	private val joinPrivateThreadOnReaction: JoinPrivateThreadOnReaction
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

	override fun onGuildMessageReactionAdd(event: GuildMessageReactionAddEvent) = runBlocking {
		updateRolesOnReaction.reactionAdded(
			UpdateRolesOnReaction.Request(
				event.messageIdLong,
				event.reactionEmote.name,
				MemberAdapter(event.member)
			)
		)

		joinPrivateThreadOnReaction.execute(
			JoinPrivateThreadOnReaction.Request(
				event.messageIdLong,
				MemberAdapter(event.member)
			)
		)
	}

	override fun onGuildMessageReactionRemove(event: GuildMessageReactionRemoveEvent) = runBlocking {
		updateRolesOnReaction.reactionRemoved(
			UpdateRolesOnReaction.Request(
				event.messageIdLong,
				event.reactionEmote.name,
				MemberAdapter(event.retrieveMember().complete())
			)
		)
	}
}
