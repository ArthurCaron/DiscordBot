package io.karon.discord_bot.infrastructure.repository_adapter

import kotlinx.coroutines.suspendCancellableCoroutine
import net.dv8tion.jda.api.requests.RestAction
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> RestAction<T>.awaitCallback(): T {
	return suspendCancellableCoroutine { cont ->
		queue(
			{ cont.resume(it) },
			{ cont.resumeWithException(it) }
		)
	}
}
