package io.karon.discord_bot.infrastructure.listeners

import io.karon.discord_bot.domain.input_port.answer_pong_to_ping.AnswerPongToPing
import io.karon.discord_bot.domain.input_port.answer_pong_to_ping.AnswerPongToPingRequest
import io.karon.discord_bot.domain.input_port.dynamic_private_thread.CreateDynamicPrivateChannel
import io.karon.discord_bot.domain.input_port.dynamic_private_thread.CreateDynamicPrivateChannelRequest
import io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction.ResetKnownTechMessage
import io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction.ResetKnownTechMessageRequest
import io.karon.discord_bot.infrastructure.output_adapter.GuildTextChannelAdapter
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.stereotype.Component
import java.util.*

@Component
final class GuildMessageEventsListener(
	jda: JDA,
	private val answerPongToPing: AnswerPongToPing,
	private val resetKnownTechMessage: ResetKnownTechMessage,
	private val createDynamicPrivateChannel: CreateDynamicPrivateChannel,
) : ListenerAdapter() {
	companion object {
		fun getGatewayIntents(): EnumSet<GatewayIntent> {
			return GatewayIntent.fromEvents(
				GuildMessageReceivedEvent::class.java,
			)
		}
	}

	init {
		jda.addEventListener(this)
	}

	override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
		answerPongToPing.execute(
			AnswerPongToPingRequest(
				event.author.isBot,
				event.message.contentRaw,
				GuildTextChannelAdapter(event.channel)
			)
		)

		resetKnownTechMessage.execute(
			ResetKnownTechMessageRequest(
				event.author.isBot,
				event.message.contentRaw,
				GuildTextChannelAdapter(event.channel)
			)
		)

		createDynamicPrivateChannel.execute(
			CreateDynamicPrivateChannelRequest(
				event.author.isBot,
				event.message.contentRaw,
				event.guild.idLong,
				GuildTextChannelAdapter(event.channel)
			)
		)
	}
}
