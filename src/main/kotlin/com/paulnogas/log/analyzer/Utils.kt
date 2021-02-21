package com.paulnogas.log.analyzer

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun toDp(textUnit: TextUnit): Dp = with(AmbientDensity.current) {
    textUnit.value.toDp()
}