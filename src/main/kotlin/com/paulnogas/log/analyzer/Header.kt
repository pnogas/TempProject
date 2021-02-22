package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(darkModeState: MutableState<Boolean>, filterViewModel: FilterViewModel, searchViewModel: SearchViewModel) {
    var isDarkMode by darkModeState
    var isRegEx by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()//.border(width = 1.dp, color = Color.Green)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,// modifier = Modifier.border(width = 1.dp, color = Color.Red)
            ) {
                SearchBar(
                    searchViewModel,
                    modifier = Modifier.weight(1f).padding(4.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Checkbox(checked = isRegEx, onCheckedChange = { isRegEx = it })
                Text("RegEx", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Switch(checked = isDarkMode,
                    onCheckedChange = { isDarkMode = it })
                Text("Dark", fontSize = 12.sp)
            }
            FilterBar(filterViewModel)
        }
    }
}
