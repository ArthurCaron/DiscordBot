package io.karon.discord_bot.domain.set_known_tech_with_reaction

import io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction.UpdateRolesOnReaction
import io.karon.discord_bot.domain.output_port.MemberPort
import io.karon.discord_bot.domain.repository_port.EmoteNamesToRolesRepository
import io.karon.discord_bot.domain.repository_port.KnownTechMessageRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class UpdateRolesOnReactionTest {
	// repository port
	private val emoteNamesToRolesRepository = mockk<EmoteNamesToRolesRepository>()
	private val knownTechMessageRepository = mockk<KnownTechMessageRepository>()

	// system under test
	private val sut = UpdateRolesOnReaction(knownTechMessageRepository, emoteNamesToRolesRepository)

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
		sut.reactionAdded(
			UpdateRolesOnReaction.Request(
1L,
				"",
				memberPort
			)
		)
		sut.reactionRemoved(
			UpdateRolesOnReaction.Request(
				1L,
				"",
				memberPort
			)
		)
//		coVerify(exactly = 0) {
//			currentGuildTextChannel.sendMessage(any())
//		}
	}
}
