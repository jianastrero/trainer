package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.datastore.ConfigDataStore
import dev.jianastrero.trainer.domain.repository.ConfigRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ConfigRepositoryImpl(
    private val dataStore: ConfigDataStore
) : ConfigRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _isDarkMode = MutableStateFlow(dataStore.getBoolean(KEY_IS_DARK_MODE, true))
    override val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    override fun setDarkMode(isDarkMode: Boolean) {
        scope.launch {
            dataStore.putBoolean(KEY_IS_DARK_MODE, isDarkMode)
            _isDarkMode.emit(isDarkMode)
        }
    }

    companion object {
        private const val KEY_IS_DARK_MODE = "KEY_IS_DARK_MODE"
    }
}
