package com.paulnogas.log.analyzer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchViewModel {
    private val parsedLogLines = Parser.parseLogLines()
    private val _displayedLogLines = mutableStateOf(parsedLogLines)
    val displayedLogLines: State<List<LogLine>> = _displayedLogLines

    private val _maxLineNumber = mutableStateOf(parsedLogLines.size)
    val maxLineNumber: State<Int> = _maxLineNumber

    private val _searchFlow = MutableStateFlow("")
    val searchTextFlow = _searchFlow.debounce(500)

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        MainScope().launch {
            searchTextFlow.collect { searchText ->
                _isLoading.value = true
                delay(1000)
                _displayedLogLines.value = parsedLogLines.filter { it.logText.contains(searchText) }
                _isLoading.value = false
            }
        }
    }

    suspend fun pushSearch(searchText: String) {
        _searchFlow.emit(searchText)
        delay(7000)
        _isLoading.value = false
    }
}