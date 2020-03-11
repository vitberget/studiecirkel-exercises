package com.hackosynth.week2.scrabblescore

object ScrabbleScore {
    private val scores = mapOf(
        listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T') to 1,
        listOf('D', 'G') to 2,
        listOf('B', 'C', 'M', 'P') to 3,
        listOf('F', 'H', 'V', 'W', 'Y') to 4,
        listOf('K') to 5,
        listOf('J', 'X') to 8,
        listOf('Q', 'Z') to 10
    )

    private val Char.scoreLetter: Int
        get() = scores[scores.keys.first { this.toUpperCase() in it }] ?: 0

    fun scoreWord(word: String): Int = word.sumBy { it.scoreLetter }
}