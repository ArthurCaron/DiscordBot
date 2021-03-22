package io.karon.discordbot.infrastructure

import io.karon.discordbot.domain.input_port.greet_new_member.GreetNewMemberRequest
import io.karon.discordbot.infrastructure.spring_input_adapter.greet_new_member.GreetNewMemberAdapter
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.stereotype.Component
import java.util.*

@Component
final class GuildMemberEventsListener(
	jda: JDA,
	private val greetNewMemberAdapter: GreetNewMemberAdapter
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
		greetNewMemberAdapter.execute(
			GreetNewMemberRequest(
				event.member.user.asMention
			)
		)
	}
}
