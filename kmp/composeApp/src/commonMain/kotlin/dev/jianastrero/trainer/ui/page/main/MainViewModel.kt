package dev.jianastrero.trainer.ui.page.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.IsDarkModeUseCase
import dev.jianastrero.trainer.domain.enumeration.BottomNavItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    isDarkModeUseCase: IsDarkModeUseCase,
) : ViewModel() {

    val isDarkMode = isDarkModeUseCase()

    private val _selectedBottomNavItem = MutableStateFlow(BottomNavItem.Swipe)
    val selectedBottomNavItem = _selectedBottomNavItem.asStateFlow()

    fun setSelectedBottomNavItem(bottomNavItem: BottomNavItem) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                _selectedBottomNavItem.emit(bottomNavItem)
            }
        }
    }

}
