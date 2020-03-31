package com.hackosynth.week3.diamond

object Diamond {
    fun printToList(letter: Char): List<String> = aToLetterToA(letter).map { line(letter, it) }

    private fun aToLetterToA(letter: Char): List<Char> {
        val aToLetter = 'A'..letter
        return aToLetter + aToLetter.reversed().drop(1)
    }

    private fun line(letter: Char, current: Char): String {
        val outerPadding = outerPadding(letter, current)
        return when (current) {
            'A' -> outerPadding + current + outerPadding
            else -> outerPadding + current + innerPadding(current) + current + outerPadding
        }
    }

    private fun outerPadding(letter: Char, current: Char) = " ".repeat(letter - current)
    private fun innerPadding(current: Char) = " ".repeat(2 * (current - 'A') - 1)
}