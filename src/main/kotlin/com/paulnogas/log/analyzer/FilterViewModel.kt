package com.paulnogas.log.analyzer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class FilterViewModel {
    private val _allFilters = mutableStateOf(listOf<LogFilter>())
    val allFilters: State<List<LogFilter>> = _allFilters

    fun loadFilters(newFilters: List<LogFilter>) {
        _allFilters.value = newFilters
    }

    fun toggleFilterEnabled(filter: LogFilter) {
        _allFilters.value.run {
            find {
                it == filter
            }?.apply {
                isEnabledState.value = !isEnabledState.value
            }
        }
    }
}