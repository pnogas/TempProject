package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Footer() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Outlined.List,
                tint = Color.Yellow.copy(alpha = 0.8f),
                modifier = Modifier.height(toDp(MaterialTheme.typography.body2.fontSize))
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text("1", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                Icons.Outlined.Info,
                tint = Color.Red.copy(alpha = 0.8f),
                modifier = Modifier.height(toDp(MaterialTheme.typography.body2.fontSize))
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text("2", color = MaterialTheme.colors.onPrimary, style = MaterialTheme.typography.body2)
        }
    }
}