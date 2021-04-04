package io.karon.discord_bot.domain.input_port.dynamic_private_thread

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.repository_port.MemberRoleRepository
import io.karon.discord_bot.domain.repository_port.PrivateThreadRepository
import io.karon.discord_bot.domain.repository_port.TextChannelRepository
import kotlin.random.Random

open class CreateDynamicPrivateChannel(
	private val textChannelRepository: TextChannelRepository,
	private val memberRoleRepository: MemberRoleRepository,
	private val privateThreadRepository: PrivateThreadRepository
) {
	private val random = Random
	private val categoryName = "THREADS"

	suspend fun execute(input: Request) {
		if (input.isAuthorABot) return
		if (input.messageReceived.startsWith("!thread ")) {
			val name = getCleanName(input.messageReceived)
			val channelName = "thread_$name"

			val guildTextChannel = textChannelRepository.createTextChannel(channelName, categoryName) ?: return
			guildTextChannel.makePrivate()

			val memberRole = memberRoleRepository.createRole(input.guildId, name) ?: return
			guildTextChannel.giveAccessToRole(memberRole)

			val guildMessage = input.currentGuildTextChannel.sendMessage(getMessage(guildTextChannel)) ?: return
			privateThreadRepository.savePrivateThread(
				PrivateThread(
					guildTextChannel,
					memberRole,
					guildMessage
				)
			)
		}
	}

	private fun getCleanName(messageReceived: String): String {
		return messageReceived
			.removePrefix("!thread ")
			.sanitize()
			.plus("-")
			.plus(random.nextInt())
	}

	private fun String.sanitize(): String {
		return trim()
			.replace(" ", "-")
			.replace("[^a-zA-Z0-9]", "")
	}

	private fun getMessage(guildTextChannel: GuildTextChannelPort): String {
		return "Private thread [${guildTextChannel.asMention()}] successfully created. Add a reaction to this message to join!"
	}

	data class Request(
		val isAuthorABot: Boolean,
		val messageReceived: String,
		val guildId: Long,
		val currentGuildTextChannel: GuildTextChannelPort
	)
}
