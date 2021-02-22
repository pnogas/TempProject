package com.paulnogas.log.analyzer.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val DefaultTypography = Typography(
    h4 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Fonts.jetbrainsMono(),
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)