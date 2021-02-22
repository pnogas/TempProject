package com.paulnogas.log.analyzer

class FilterViewModel() {
    val allFilters = mutableListOf<LogFilter>()

    fun loadFilters(newFilters: List<LogFilter>) {
        allFilters.clear()
        allFilters.addAll(newFilters)
    }

    fun toggleFilterEnabled(filter: LogFilter) {
        allFilters.first { it == filter }.run {
            isEnabled = !isEnabled
        }
        println(allFilters.filter { it.isEnabled })
    }
}