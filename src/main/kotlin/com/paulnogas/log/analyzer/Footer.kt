package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Footer(searchViewModel: SearchViewModel) {
    val isLoading by searchViewModel.isLoading
    val footerHeight = MaterialTheme.typography.body2.fontSize.toDp()
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Outlined.List,
                tint = Color.Yellow.copy(alpha = 0.8f),
                modifier = Modifier.height(footerHeight)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text("1", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                Icons.Outlined.Info,
                tint = Color.Red.copy(alpha = 0.8f),
                modifier = Modifier.height(footerHeight)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text("2", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)

            if (isLoading) {
                Spacer(modifier = Modifier.width(2.dp).weight(1.0f))
                Text("Loading....", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)
                CircularProgressIndicator(
                    modifier = Modifier.size(footerHeight),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}