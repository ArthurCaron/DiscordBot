package io.karon.discordbot.domain.input_port

import io.karon.discordbot.domain.output_port.GuildMessage
import io.karon.discordbot.domain.output_port.GuildTextChannel
import io.karon.discordbot.domain.output_port.MemberRole

data class PrivateThread(
	val guildTextChannel: GuildTextChannel,
	val memberRole: MemberRole,
	val guildMessage: GuildMessage
)
