package io.karon.discordbot.domain.input_port.dynamic_private_thread

import io.karon.discordbot.domain.output_port.MessagePort
import io.karon.discordbot.domain.output_port.GuildTextChannelPort
import io.karon.discordbot.domain.output_port.MemberRolePort

data class PrivateThread(
	val guildTextChannel: GuildTextChannelPort,
	val memberRole: MemberRolePort,
	val message: MessagePort
)
