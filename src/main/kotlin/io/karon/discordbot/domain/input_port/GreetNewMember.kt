package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.api.GreetNewMemberRequest
import io.karon.discordbot.domain.repository_adapter.TextChannelRepository

open class GreetNewMember(private val textChannelRepository: TextChannelRepository) {
	private val destinationChannelName = "bot_test"
	private val mentionedChannelName = "gartic_phone"

	fun execute(input: GreetNewMemberRequest) {
		textChannelRepository.getTextChannelByName(destinationChannelName)?.let { destinationChannel ->
			val mentionedChannel = textChannelRepository.getTextChannelByName(mentionedChannelName)?.asMention() ?: mentionedChannelName
			val greeting = getGreeting(input.userAsMention, mentionedChannel)
			destinationChannel.sendMessage(greeting)
		}
	}

	private fun getGreeting(mentionedUser: String, mentionedChannel: String) =
		"Hey $mentionedUser, Bienvenue parmi nous !  :wave: :partying_face::sparkler:  N'hésites pas à venir te présenter sur $mentionedChannel histoire de faire connaissance :wink:"
}
