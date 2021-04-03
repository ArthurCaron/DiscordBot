package io.karon.discord_bot.infrastructure

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

fun main() {
	val numbers = listOf("one", "two", "three", "four", "five")

	println(numbers.groupBy { test(it) })
	println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

//	val deferred = (1..1_000_000).map { n ->
//		GlobalScope.async {
//			workload(n)
//		}
//	}
//
//	runBlocking {
//		val sum = deferred.sumOf { it.await().toLong() }
//		println("Sum: $sum")
//	}
}

private fun test(it: String) = it.first().toUpperCase()

private suspend fun workload(n: Int): Int {
	delay(1000)
	return n
}
