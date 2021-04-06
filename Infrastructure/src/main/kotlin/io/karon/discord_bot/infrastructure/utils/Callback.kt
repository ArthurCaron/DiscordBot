package io.karon.discord_bot.infrastructure.utils

import kotlinx.coroutines.future.await
import kotlinx.coroutines.suspendCancellableCoroutine
import net.dv8tion.jda.api.requests.RestAction
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

// Encouraged
suspend fun <T> RestAction<T>.awaitCancellable(): T =
	suspendCancellableCoroutine { cont ->
		queue({ cont.resume(it) }, { cont.resumeWithException(it) })
	}

suspend fun <T> RestAction<T>.await(): T =
	submit().await()
