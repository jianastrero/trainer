package dev.jianastrero.trainer.ui.page.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.IsDarkModeUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import dev.jianastrero.trainer.domain.enumeration.BottomNavItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    isDarkModeUseCase: IsDarkModeUseCase,
) : ViewModel() {

    private val _isDarkMode = MutableStateFlow(isDarkModeUseCase())
    val isDarkMode = _isDarkMode.asStateFlow()

    private val _selectedBottomNavItem = MutableStateFlow(BottomNavItem.Home)
    val selectedBottomNavItem = _selectedBottomNavItem.asStateFlow()

    fun setSelectedBottomNavItem(bottomNavItem: BottomNavItem) {
        viewModelScope.launch {
            _selectedBottomNavItem.emit(bottomNavItem)
        }
    }

}
