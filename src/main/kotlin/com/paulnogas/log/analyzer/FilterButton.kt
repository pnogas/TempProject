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
import kotlin.random.Random

@Composable
fun FilterButton(text: String) {
    var enabled by remember { mutableStateOf(false) }
    val buttonColor = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat())

    Button(
        onClick = { enabled = !enabled },
        shape = RoundedCornerShape(2.dp),
        contentPadding = PaddingValues(start = 4.dp, end = 4.dp),
        border = BorderStroke(2.dp, buttonColor),
        colors = ButtonConstants.defaultButtonColors(backgroundColor = if (enabled) buttonColor else Color.Transparent)
    ) {
        Text(text)
    }
}