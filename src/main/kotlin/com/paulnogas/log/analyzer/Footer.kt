package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Footer() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.Info, tint = Color.Green.copy(alpha = 0.8f), modifier = Modifier.height(toDp(MaterialTheme.typography.body2.fontSize)))
            Spacer(modifier = Modifier.width(2.dp))
            Text("1", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(Icons.Filled.Warning, tint = Color.Yellow.copy(alpha = 0.8f), modifier = Modifier.height(toDp(MaterialTheme.typography.body2.fontSize)))
            Spacer(modifier = Modifier.width(2.dp))
            Text("2", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)
        }
    }
}