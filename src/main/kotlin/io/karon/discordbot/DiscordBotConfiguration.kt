package io.karon.discordbot

import io.karon.discordbot.infrastructure.GuildMemberEventsListener
import io.karon.discordbot.infrastructure.GuildMessageEventsListener
import io.karon.discordbot.infrastructure.GuildMessageReactionEventsListener
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.utils.cache.CacheFlag
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiscordBotConfiguration {
	@Bean
	fun jda(@Value("\${discord.token}") discordToken: String): JDA {
		val gatewayIntents = mutableSetOf(
			GuildMessageEventsListener.getGatewayIntents(),
			GuildMemberEventsListener.getGatewayIntents(),
			GuildMessageReactionEventsListener.getGatewayIntents(),
		).flatten()
//			.toMutableList()
//		gatewayIntents
//			.add(GatewayIntent.GUILD_EMOJIS)

		return JDABuilder.create(discordToken, gatewayIntents)
			.setActivity(Activity.watching("you"))
//			.enableCache(CacheFlag.EMOTE)
			.disableCache(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE, CacheFlag.CLIENT_STATUS)
			.build()
	}
}
