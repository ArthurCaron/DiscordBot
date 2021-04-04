package io.karon.discord_bot.domain.set_known_tech_with_reaction

import io.karon.discord_bot.domain.input_port.set_known_tech_with_reaction.ResetKnownTechMessage
import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.repository_port.EmoteNamesToEmoteUnicodesRepository
import io.karon.discord_bot.domain.repository_port.KnownTechMessageRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class ResetKnownTechMessageTest {
	// repository port
	private val emoteNamesToEmoteUnicodesRepository = mockk<EmoteNamesToEmoteUnicodesRepository>()
	private val knownTechMessageRepository = mockk<KnownTechMessageRepository>()

	// system under test
	private val sut = ResetKnownTechMessage(knownTechMessageRepository, emoteNamesToEmoteUnicodesRepository)

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
			ResetKnownTechMessage.Request(
				true,
				"",
				currentGuildTextChannel
			)
		)
		coVerify(exactly = 0) {
			currentGuildTextChannel.sendMessage(any())
			knownTechMessageRepository.getKnownTechMessage()
			knownTechMessageRepository.setKnownTechMessage(any())
			emoteNamesToEmoteUnicodesRepository.getCustomEmotes(any())
		}
	}
}
