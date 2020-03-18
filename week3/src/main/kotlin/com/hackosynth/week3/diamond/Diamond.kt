package com.hackosynth.week3.diamond

object Diamond {
    fun printToList(letter: Char): List<String> =
        aToLetterToA(letter)
            .map { line(letter, it) }

    private fun aToLetterToA(letter: Char):List<Char> {
        val aToLetter = 'A'..letter
        return aToLetter + aToLetter.reversed().drop(1)
    }

    private fun line(letter: Char, current: Char): String {
        val padding = " ".repeat(letter - current)
        return when (current) {
            'A' -> padding + current + padding
            else -> padding + current + " ".repeat((current - 'A') * 2 - 1) + current + padding
        }
    }
}