package com.hackosynth.week3.isogram

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IsogramTest {
    companion object {
        @JvmStatic
        fun data() = listOf(
            arrayOf("", true),
            arrayOf("isogram", true),
            arrayOf("eleven", false),
            arrayOf("zzyzx", false),
            arrayOf("subdermatoglyphic", true),
            arrayOf("Alphabet", false),
            arrayOf("alphAbet", false),
            arrayOf("thumbscrew-japingly", true),
            arrayOf("thumbscrew-jappingly", false),
            arrayOf("six-year-old", true),
            arrayOf("Emily Jung Schwartzkopf", true),
            arrayOf("accentor", false),
            arrayOf("angola", false),
            arrayOf("The qUick broWn fox Jumps ovEr the lazy dog", false)
        )
    }

    @ParameterizedTest
    @MethodSource("data")
    fun `Test some words`(input: String, expectedOutput: Boolean) {
        assertEquals(expectedOutput, Isogram.isIsogram(input))
    }
}