package io.karon.discord_bot.domain.greet_new_member

import io.karon.discord_bot.domain.input_port.greet_new_member.GreetNewMember
import io.karon.discord_bot.domain.repository_port.TextChannelRepository
import io.mockk.clearAllMocks
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class GreetNewMemberTest {
	// repository port
	private val textChannelRepository = mockk<TextChannelRepository>()

	// system under test
	private val sut = GreetNewMember(textChannelRepository)

	@BeforeEach
	fun beforeEach() {
		clearAllMocks()
	}

	// NOT VALID
	@Test
	fun `if author is bot then do nothing`() = runBlockingTest {
		sut.execute(
			GreetNewMember.Request(
				""
			)
		)
//		coVerify(exactly = 0) {
//			currentGuildTextChannel.sendMessage(any())
//		}
	}
}
