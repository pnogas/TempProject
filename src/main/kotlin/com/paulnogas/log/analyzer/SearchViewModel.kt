package com.paulnogas.log.analyzer


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel {
    private val _searchString = mutableStateOf("")
    val searchString: State<String> = _searchString

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun doSearch(searchText: String) {
        _isLoading.value = true
        GlobalScope.launch {
            delay(1000L)
            _isLoading.value = false
        }
    }
}
