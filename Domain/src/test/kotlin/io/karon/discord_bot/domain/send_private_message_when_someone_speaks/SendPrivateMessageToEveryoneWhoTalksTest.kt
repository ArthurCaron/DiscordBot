package io.karon.discord_bot.domain.send_private_message_when_someone_speaks

import io.karon.discord_bot.domain.input_port.send_private_message_when_someone_speaks.SendPrivateMessageToEveryoneWhoTalks
import io.karon.discord_bot.domain.repository_port.UserRepository
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class SendPrivateMessageToEveryoneWhoTalksTest {
	// repository port
	private val userRepository = mockk<UserRepository>()

	// system under test
	private val sut = SendPrivateMessageToEveryoneWhoTalks(userRepository)

	@BeforeEach
	fun beforeEach() {
		clearAllMocks()
	}

	@Test
	fun `if author is bot then do nothing`() = runBlockingTest {
		sut.execute(
			SendPrivateMessageToEveryoneWhoTalks.Request(
				true,
				"userId"
			)
		)
		coVerify(exactly = 0) {
			userRepository.getUserById(any())
		}
	}
}
