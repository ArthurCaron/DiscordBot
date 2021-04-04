package io.karon.discord_bot.domain.input_port.greet_new_member

import io.karon.discord_bot.domain.repository_port.TextChannelRepository

open class GreetNewMember(private val textChannelRepository: TextChannelRepository) {
	private val destinationChannelName = "bot_test"
	private val mentionedChannelName = "gartic_phone"

	suspend fun execute(input: Request) {
		textChannelRepository.getTextChannelByName(destinationChannelName)?.let { destinationChannel ->
			val mentionedChannel = textChannelRepository.getTextChannelByName(mentionedChannelName)?.asMention() ?: mentionedChannelName
			val greeting = getGreeting(input.userAsMention, mentionedChannel)
			destinationChannel.sendMessage(greeting)
		}
	}

	private fun getGreeting(mentionedUser: String, mentionedChannel: String) =
		"Hey $mentionedUser, Bienvenue parmi nous !  :wave: :partying_face::sparkler:  N'hésites pas à venir te présenter sur $mentionedChannel histoire de faire connaissance :wink:"

	data class Request(
		val userAsMention: String
	)
}
