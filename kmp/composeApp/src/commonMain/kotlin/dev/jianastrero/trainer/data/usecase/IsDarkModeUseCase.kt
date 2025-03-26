package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.ConfigRepository
import kotlinx.coroutines.flow.StateFlow

class IsDarkModeUseCase(
    private val repository: ConfigRepository
) {

    operator fun invoke(): StateFlow<Boolean> = repository.isDarkMode

}
