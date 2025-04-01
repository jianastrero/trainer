package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import dev.jianastrero.trainer.domain.repository.ConfigRepository
import org.kodein.mock.Mock
import org.kodein.mock.generated.injectMocks
import org.kodein.mock.generated.mock
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.Test
import kotlin.test.assertEquals

class ConfigRepositoryTest : TestsWithMocks() {

    @Mock var configDataStore: ConfigDataStore = mocker.mock()

    private lateinit var configRepository: ConfigRepository

    override fun setUpMocks() {
        mocker.injectMocks(this)

        val booleanMap = mutableMapOf<String, Boolean>()

        every {
            configDataStore.getBoolean(isAny(), isAny())
        } runs { args ->
            val key = args[0] as String
            val defaultValue = args[1] as Boolean
            booleanMap[key] ?: defaultValue
        }

        configRepository = ConfigRepositoryImpl(configDataStore)
    }

    @Test
    fun `getDarkMode returns default`() {
        // Arrange
        val expected = true
        val booleanMap = mutableMapOf<String, Boolean>()
        every {
            configDataStore.getBoolean(isAny(), isAny())
        } runs { args ->
            val key = args[0] as String
            val defaultValue = args[1] as Boolean
            booleanMap[key] ?: defaultValue
        }

        // Act
        val isDarkMode = configRepository.isDarkMode.value

        // Assert
        assertEquals(expected, isDarkMode)
    }
}
