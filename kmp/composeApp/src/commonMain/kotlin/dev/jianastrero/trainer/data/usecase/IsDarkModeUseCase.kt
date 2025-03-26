package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.ConfigRepository

class IsDarkModeUseCase(
    private val repository: ConfigRepository
) {

    operator fun invoke(): Boolean {
        return repository.isDarkMode
    }

}
