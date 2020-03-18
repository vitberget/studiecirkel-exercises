package com.hackosynth.week2.scrabblescore

object ScrabbleScore {

    fun scoreWord(word: String): Int =
        word.toUpperCase()
            .map { scoreLetter(it) }
            .sum()

    fun scoreLetter(c: Char): Int =
        when (c) {
            in "AEIOULNRST" -> 1
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            in "K" -> 5
            in "JX" -> 8
            in "QZ" -> 10
            else -> 0
        }
}