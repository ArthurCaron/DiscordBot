package io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort

data class ResetKnownTechMessageRequest(
	val isAuthorABot: Boolean,
	val messageReceived: String,
	val currentGuildTextChannel: GuildTextChannelPort
)
