package com.paulnogas.log.analyzer

import androidx.compose.ui.graphics.Color

data class LogFilter(val name: String, val regex: Regex, val color: Color, var isEnabled: Boolean = false)