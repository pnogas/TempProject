package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterBar(
    filterViewModel: FilterViewModel,
) {
    val selectedIndices = mutableStateListOf<Boolean>()
    MyFlowRow(
        modifier = Modifier.padding(2.dp),
        horizontalGap = 4.dp,
        verticalGap = 2.dp,
    ) {
        filterViewModel.allFilters.forEach { logFilter ->
            FilterButton(logFilter, onClickHandler = { filterViewModel.toggleFilterEnabled(logFilter) })
        }
    }
}