package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.CreateDynamicPrivateChannelRequest
import io.karon.discordbot.domain.repository_adapter.MemberRoleRepository
import io.karon.discordbot.domain.repository_adapter.PrivateThreadRepository
import io.karon.discordbot.domain.repository_adapter.TextChannelRepository
import kotlin.random.Random

open class CreateDynamicPrivateChannel(
	private val textChannelRepository: TextChannelRepository,
	private val memberRoleRepository: MemberRoleRepository,
	private val privateThreadRepository: PrivateThreadRepository
) {
	private val random = Random
	private val categoryName = "THREADS"

	fun execute(input: CreateDynamicPrivateChannelRequest) {
		if (input.isAuthorABot) return
		if (input.messageReceived.startsWith("!thread ")) {
			val name = getCleanName(input.messageReceived)
			val channelName = "thread_$name"

			// I really need coroutines to remove the callback hell
			textChannelRepository.createPrivateTextChannel(channelName, categoryName) { guildTextChannel ->
				guildTextChannel.makePrivate()
				memberRoleRepository.createRole(input.guildId, name) { memberRole ->
					guildTextChannel.giveAccessToRole(memberRole)

					input.currentGuildTextChannel.sendMessage("Private thread [${guildTextChannel.asMention()}] successfully created. Add a reaction to this message to join!") { guildMessage ->
						privateThreadRepository.registerPrivateThread(
							PrivateThread(
								guildTextChannel,
								memberRole,
								guildMessage
							)
						)
					}
				}
			}
		}
	}

	private fun getCleanName(messageReceived: String) = messageReceived
		.removePrefix("!thread ")
		.sanitize()
		.plus("-")
		.plus(random.nextInt())

	private fun String.sanitize(): String {
		return trim()
			.replace(" ", "-")
			.replace("[^a-zA-Z0-9]", "")
	}
}
