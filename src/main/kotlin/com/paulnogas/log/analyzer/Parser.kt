package com.paulnogas.log.analyzer

object Parser {
    fun parseLogLines(): List<LogLine> =
        TempText.text.mapIndexed { index, rawText ->
            LogLine(index, rawText)
        }.toList()
}
