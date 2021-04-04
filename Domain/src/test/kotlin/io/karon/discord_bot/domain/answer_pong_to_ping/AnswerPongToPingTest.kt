package io.karon.discord_bot.domain.answer_pong_to_ping

import io.karon.discord_bot.domain.input_port.answer_pong_to_ping.AnswerPongToPing
import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class AnswerPongToPingTest {
	// system under test
	private val sut = AnswerPongToPing()

	// output port
	private val currentGuildTextChannel = mockk<GuildTextChannelPort>()

	@BeforeEach
	fun beforeEach() {
		clearAllMocks()
		coEvery { currentGuildTextChannel.sendMessage(any()) } returns mockk()
	}

	@Test
	fun `if author is bot then do nothing`() = runBlockingTest {
		sut.execute(
			AnswerPongToPing.Request(
				true,
				"",
				currentGuildTextChannel
			)
		)
		coVerify(exactly = 0) {
			currentGuildTextChannel.sendMessage(any())
		}
	}

	@Test
	fun `if message doesn't start with !ping then do nothing`() = runBlockingTest {
		sut.execute(
			AnswerPongToPing.Request(
				false,
				"!not ping",
				currentGuildTextChannel
			)
		)
		coVerify(exactly = 0) {
			currentGuildTextChannel.sendMessage(any())
		}
	}

	@Test
	fun `if message starts with !ping then send PONG message`() = runBlockingTest {
		sut.execute(
			AnswerPongToPing.Request(
				false,
				"!ping",
				currentGuildTextChannel
			)
		)
		coVerify(exactly = 1) {
			currentGuildTextChannel.sendMessage(any())
		}
	}
}
