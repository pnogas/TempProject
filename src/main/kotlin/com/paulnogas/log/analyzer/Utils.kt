package com.paulnogas.log.analyzer

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextUnit.toDp(): Dp = convertToDp(this.value)

@Composable
fun convertToDp(value: Float): Dp {
    return with(AmbientDensity.current) {
        value.toDp()
    }
}