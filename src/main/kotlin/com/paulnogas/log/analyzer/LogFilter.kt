package com.paulnogas.log.analyzer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class LogFilter(
    val name: String,
    val regex: Regex,
    val color: Color,
    var isEnabledState: MutableState<Boolean> = mutableStateOf(false)
)