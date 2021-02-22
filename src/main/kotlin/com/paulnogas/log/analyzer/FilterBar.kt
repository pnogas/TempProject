package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterBar(
    filterViewModel: FilterViewModel,
) {
    val filterState by mutableStateOf(filterViewModel.allFilters.value)
    MyFlowRow(
        modifier = Modifier.padding(2.dp),
        horizontalGap = 4.dp,
        verticalGap = 2.dp,
    ) {
        filterState.forEach { logFilter ->
            FilterButton(
                logFilter,
                isEnabledState = logFilter.isEnabledState,
                onClickHandler = { filterViewModel.toggleFilterEnabled(logFilter) })
        }
    }
}