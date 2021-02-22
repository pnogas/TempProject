package com.paulnogas.log.analyzer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonConstants
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterButton(logFilter: LogFilter, onClickHandler: () -> Unit) {
    var enabled by remember { mutableStateOf(logFilter.isEnabled) }
    Button(
        onClick = {
            enabled = !enabled
            onClickHandler()
        },
        shape = RoundedCornerShape(2.dp),
        contentPadding = PaddingValues(start = 4.dp, end = 4.dp),
        border = BorderStroke(2.dp, logFilter.color),
        colors = ButtonConstants.defaultButtonColors(backgroundColor = if (enabled) logFilter.color else Color.Transparent)
    ) {
        Text(logFilter.name)
    }
}