package io.karon.discord_bot.domain.input_port.dynamic_private_thread

import io.karon.discord_bot.domain.output_port.MessagePort
import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.output_port.MemberRolePort

data class PrivateThread(
	val guildTextChannel: GuildTextChannelPort,
	val memberRole: MemberRolePort,
	val message: MessagePort
)
