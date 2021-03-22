package io.karon.discord_bot.infrastructure.output_adapter

import io.karon.discord_bot.domain.output_port.MessagePort
import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.output_port.MemberRolePort
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.TextChannel

class GuildTextChannelAdapter(private val textChannel: TextChannel) : GuildTextChannelPort {
	override fun sendMessage(message: String) {
		textChannel.sendMessage(message).queue()
	}

	override fun sendMessage(message: String, onSuccess: (MessagePort) -> Unit) {
		textChannel.sendMessage(message).queue { createdMessage ->
			onSuccess(MessageAdapter(createdMessage))
		}
	}

	override fun asMention() = textChannel.asMention

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
