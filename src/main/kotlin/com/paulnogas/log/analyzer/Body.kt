package com.paulnogas.log.analyzer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.selection.DisableSelection
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Body(tempText: List<String>) {
    val maxLineNumberWidthText = remember(tempText.size) {
        (1..tempText.size.toString().length).joinToString("") { "9" } // nine is the widest number (in case font changes
    }

    Box(Modifier.fillMaxSize()) {
        val scrollState = rememberLazyListState()
        val lineHeight = MaterialTheme.typography.body1.fontSize.toDp() * 1.6f

        LazyColumnForIndexed(
            tempText,
            modifier = Modifier.fillMaxSize(),
            state = scrollState,
            itemContent = { lineNumber, text ->
                Box(Modifier.height(lineHeight)) {
                    LogLine(Modifier.align(Alignment.CenterStart), maxLineNumberWidthText, lineNumber, text)
                }
            }
        )

        VerticalScrollbar(
            rememberScrollbarAdapter(scrollState, tempText.size, lineHeight),
            Modifier.align(Alignment.CenterEnd),
        )
    }
}

@Composable
private fun LogLine(modifier: Modifier, maxLineNumberWidthText: String, lineNumber: Int, text: String) {
    Row(modifier = modifier.padding(start = 10.dp, end = 10.dp)) {
        DisableSelection {
            Box {
                Text(maxLineNumberWidthText, Modifier.alpha(0f)) // hack to keep the width, should change
                Text(lineNumber.toString(), Modifier.align(Alignment.CenterEnd))
            }
        }
        Text(text, modifier = Modifier.padding(start = 10.dp, end = 10.dp))
    }
}