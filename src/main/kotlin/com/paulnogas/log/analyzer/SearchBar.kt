package com.paulnogas.log.analyzer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SearchBar(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.onPrimary,
    backgroundColor: Color = MaterialTheme.colors.primaryVariant,
) {
    var searchText by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(4.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.Search,
            tint = textColor,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.caption.copy(color = textColor),
            value = searchText,
            onValueChange = {
                searchText = it
                coroutineScope.launch {
                    searchViewModel.pushSearch(it)
                }
            },
            cursorColor = textColor,
            singleLine = true
        )
    }
}