package com.paulnogas.log.analyzer.ui.theme

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.fontFamily
import androidx.compose.ui.text.platform.font

object Fonts {
    fun jetbrainsMono() = fontFamily(
        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_regular.ttf",
            FontWeight.Normal,
            FontStyle.Normal
        ),
        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_italic.ttf",
            FontWeight.Normal,
            FontStyle.Italic
        ),

        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_bold.ttf",
            FontWeight.Bold,
            FontStyle.Normal
        ),
        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_bold_italic.ttf",
            FontWeight.Bold,
            FontStyle.Italic
        ),

        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_extrabold.ttf",
            FontWeight.ExtraBold,
            FontStyle.Normal
        ),
        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_extrabold_italic.ttf",
            FontWeight.ExtraBold,
            FontStyle.Italic
        ),

        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_medium.ttf",
            FontWeight.Medium,
            FontStyle.Normal
        ),
        font(
            "JetBrains Mono",
            "fonts/jetbrainsmono_medium_italic.ttf",
            FontWeight.Medium,
            FontStyle.Italic
        )
    )
}