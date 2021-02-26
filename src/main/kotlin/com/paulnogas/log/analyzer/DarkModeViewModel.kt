package com.paulnogas.log.analyzer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class DarkModeViewModel {
    private val _isDarkMode = mutableStateOf(true)
    val isDarkMode: State<Boolean> = _isDarkMode

    fun toggleDarkMode() {
        _isDarkMode.value = !isDarkMode.value
    }
}
