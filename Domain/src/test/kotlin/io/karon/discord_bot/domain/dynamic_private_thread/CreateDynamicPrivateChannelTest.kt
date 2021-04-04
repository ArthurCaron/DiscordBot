package io.karon.discord_bot.domain.dynamic_private_thread

import io.karon.discord_bot.domain.input_port.dynamic_private_thread.CreateDynamicPrivateChannel
import io.karon.discord_bot.domain.output_port.GuildTextChannelPort
import io.karon.discord_bot.domain.repository_port.MemberRoleRepository
import io.karon.discord_bot.domain.repository_port.PrivateThreadRepository
import io.karon.discord_bot.domain.repository_port.TextChannelRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class CreateDynamicPrivateChannelTest {
	// repository port
	private val memberRoleRepository = mockk<MemberRoleRepository>()
	private val privateThreadRepository = mockk<PrivateThreadRepository>()
	private val textChannelRepository = mockk<TextChannelRepository>()

	// system under test
	private val sut = CreateDynamicPrivateChannel(textChannelRepository, memberRoleRepository, privateThreadRepository)

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
			CreateDynamicPrivateChannel.Request(
				true,
				"",
				1L,
				currentGuildTextChannel
			)
		)
		coVerify(exactly = 0) {
			textChannelRepository.createTextChannel(any(), any())
			memberRoleRepository.createRole(any(), any())
			currentGuildTextChannel.sendMessage(any())
			privateThreadRepository.savePrivateThread(any())
		}
	}
}
