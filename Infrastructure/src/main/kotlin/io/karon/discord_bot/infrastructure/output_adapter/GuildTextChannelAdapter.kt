package io.karon.discord_bot.infrastructure.output_adapter

import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.output_port.MemberRolePort
import io.karon.discord_bot.domain.output_port.MessagePort
import io.karon.discord_bot.infrastructure.repository_adapter.awaitCallback
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.TextChannel

class GuildTextChannelAdapter(private val textChannel: TextChannel) : GuildTextChannelPort {
	override suspend fun sendMessage(message: String): MessagePort? {
		return textChannel.sendMessage(message)
			.awaitCallback()
			?.let { MessageAdapter(it) }
	}

	override fun asMention() = textChannel.asMention

	// could also return a success or failure state for error handling
	override fun makePrivate() {
		textChannel.guild
			.getRolesByName("@everyone", false)
			.firstOrNull()
			?.let {
				textChannel.createPermissionOverride(it)
					.setDeny(Permission.VIEW_CHANNEL)
					.queue()
			}
	}

	// could also return a success or failure state for error handling
	override fun giveAccessToRole(memberRole: MemberRolePort) {
		textChannel.guild
			.getRoleById(memberRole.getRoleId())
			?.let {
				textChannel.createPermissionOverride(it)
					.setAllow(Permission.VIEW_CHANNEL)
					.queue()
			}
	}
}
