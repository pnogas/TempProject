package com.paulnogas.log.analyzer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.selection.DisableSelection
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Body(searchViewModel: SearchViewModel) {
    val displayedLogLines by searchViewModel.displayedLogLines
    val maxLineNumber by searchViewModel.maxLineNumber
    val maxLineNumberWidthText = remember(maxLineNumber) {
        (1..maxLineNumber.toString().length).joinToString("") { "9" } // nine is the widest number (in case font changes)
    }

    Box(Modifier.fillMaxSize()) {
        val scrollState = rememberLazyListState()
        val lineHeight = MaterialTheme.typography.body1.fontSize.toDp() * 1.6f

        LazyColumnFor(
            displayedLogLines,
            modifier = Modifier.fillMaxSize(),
            state = scrollState,
            itemContent = {
                Box(Modifier.height(lineHeight)) {
                    LogLineView(
                        Modifier.align(Alignment.CenterStart),
                        maxLineNumberWidthText,
                        it.lineNumber,
                        it.logText
                    )
                }
            }
        )

        VerticalScrollbar(
            rememberScrollbarAdapter(scrollState, maxLineNumber, lineHeight),
            Modifier.align(Alignment.CenterEnd),
        )
    }
}

@Composable
private fun LogLineView(modifier: Modifier, maxLineNumberWidthText: String, lineNumber: Int, text: String) {
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