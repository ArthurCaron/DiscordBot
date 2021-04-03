package io.karon.discord_bot.infrastructure.listeners

import io.karon.discord_bot.domain.input_port.greet_new_member.GreetNewMember
import io.karon.discord_bot.domain.input_port.greet_new_member.GreetNewMemberRequest
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.stereotype.Component
import java.util.*

@Component
final class GuildMemberEventsListener(
	jda: JDA,
	private val greetNewMember: GreetNewMember
) : ListenerAdapter() {
	companion object {
		fun getGatewayIntents(): EnumSet<GatewayIntent> {
			return GatewayIntent.fromEvents(
				GuildMemberJoinEvent::class.java,
			)
		}
	}

	init {
		jda.addEventListener(this)
	}

	override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
		greetNewMember.execute(
			GreetNewMemberRequest(
				event.member.user.asMention
			)
		)
	}
}
