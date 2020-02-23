package com.hackosynth.week2.scrabblescore

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ScrabbleScoreTest {
    companion object {
        @JvmStatic
        fun data() = listOf(
            arrayOf("a", 1),
            arrayOf("A", 1),
            arrayOf("f", 4),
            arrayOf("at", 2),
            arrayOf("zoo", 12),
            arrayOf("street", 6),
            arrayOf("quirky", 22),
            arrayOf("OxyphenButazone", 41),
            arrayOf("pinata", 8),
            arrayOf("", 0),
            arrayOf("abcdefgHijklmnopqrStuvwXyz", 87)
        )
    }

    @ParameterizedTest
    @MethodSource("data")
    fun `Test score of some words`(word: String, score: Int) {
        assertEquals(score, ScrabbleScore.scoreWord(word))
    }
}