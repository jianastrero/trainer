package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.ConfigRepository

class SetDarkModeUseCase(
    private val repository: ConfigRepository
) {

    operator fun invoke(isDarkMode: Boolean) {
        repository.isDarkMode = isDarkMode
    }

}
