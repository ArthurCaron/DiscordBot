package io.karon.discordbot.infrastructure

import io.karon.discordbot.domain.input_port.answer_pong_to_ping.AnswerPongToPingRequest
import io.karon.discordbot.domain.input_port.dynamic_private_thread.CreateDynamicPrivateChannelRequest
import io.karon.discordbot.domain.input_port.set_known_tech_with_reaction.ResetKnownTechMessageRequest
import io.karon.discordbot.infrastructure.spring_input_adapter.answer_pong_to_ping.AnswerPongToPingAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.set_known_tech_with_reaction.ResetKnownTechMessageAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.send_private_message_when_someone_speaks.SendPrivateMessageToEveryoneWhoTalksAdapter
import io.karon.discordbot.infrastructure.output_adapter.GuildTextChannelAdapter
import io.karon.discordbot.infrastructure.spring_input_adapter.dynamic_private_thread.CreateDynamicPrivateChannelAdapter
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.stereotype.Component
import java.util.*

@Component
final class GuildMessageEventsListener(
	jda: JDA,
	private val answerPongToPingAdapter: AnswerPongToPingAdapter,
	private val resetKnownTechMessageAdapter: ResetKnownTechMessageAdapter,
	private val createDynamicPrivateChannelAdapter: CreateDynamicPrivateChannelAdapter,
	private val sendPrivateMessageToEveryoneWhoTalksAdapter: SendPrivateMessageToEveryoneWhoTalksAdapter
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
		answerPongToPingAdapter.execute(
			AnswerPongToPingRequest(
				event.author.isBot,
				event.message.contentRaw,
				GuildTextChannelAdapter(event.channel)
			)
		)

		resetKnownTechMessageAdapter.execute(
			ResetKnownTechMessageRequest(
				event.author.isBot,
				event.message.contentRaw,
				GuildTextChannelAdapter(event.channel)
			)
		)

		createDynamicPrivateChannelAdapter.execute(
			CreateDynamicPrivateChannelRequest(
				event.author.isBot,
				event.message.contentRaw,
				event.guild.idLong,
				GuildTextChannelAdapter(event.channel)
			)
		)

//		event.member?.user?.id?.let { userId ->
//			sendPrivateMessageToEveryoneWhoTalksAdapter.execute(
//				SendPrivateMessageToEveryoneWhoTalksRequest(
//					event.author.isBot,
//					userId
//				)
//			)
//		}
	}
}
