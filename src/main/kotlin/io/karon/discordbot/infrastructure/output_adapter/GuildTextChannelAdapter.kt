package io.karon.discordbot.infrastructure.output_adapter

import io.karon.discordbot.domain.output_port.GuildMessage
import io.karon.discordbot.domain.output_port.GuildTextChannel
import io.karon.discordbot.domain.output_port.MemberRole
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.TextChannel

class GuildTextChannelAdapter(private val textChannel: TextChannel) : GuildTextChannel {
	override fun sendMessage(message: String) {
		textChannel.sendMessage(message).queue()
	}

	override fun sendMessage(message: String, onSuccess: (GuildMessage) -> Unit) {
		textChannel.sendMessage(message).queue { createdMessage ->
			onSuccess(GuildMessageAdapter(createdMessage))
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

	override fun giveAccessToRole(memberRole: MemberRole) {
		textChannel.guild
			.getRoleById(memberRole.getRoleId())
			?.let {
				textChannel.createPermissionOverride(it)
					.setAllow(Permission.VIEW_CHANNEL)
					.queue()
			}
	}
}
