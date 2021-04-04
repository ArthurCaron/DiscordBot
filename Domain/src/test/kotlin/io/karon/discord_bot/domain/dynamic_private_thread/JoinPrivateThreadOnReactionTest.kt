package io.karon.discord_bot.domain.dynamic_private_thread

import io.karon.discord_bot.domain.input_port.dynamic_private_thread.JoinPrivateThreadOnReaction
import io.karon.discord_bot.domain.output_port.MemberPort
import io.karon.discord_bot.domain.repository_port.PrivateThreadRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class JoinPrivateThreadOnReactionTest {
	// repository port
	private val privateThreadRepository = mockk<PrivateThreadRepository>()

	// system under test
	private val sut = JoinPrivateThreadOnReaction(privateThreadRepository)

	// output port
	private val memberPort = mockk<MemberPort>()

	@BeforeEach
	fun beforeEach() {
		clearAllMocks()
		coEvery { memberPort.addRole(any()) } returns mockk()
	}

	// NOT VALID
	@Test
	fun `if author is bot then do nothing`() = runBlockingTest {
		sut.execute(
			JoinPrivateThreadOnReaction.Request(
1L,
				memberPort
			)
		)
//		coVerify(exactly = 0) {
//			currentGuildTextChannel.sendMessage(any())
//		}
	}
}
