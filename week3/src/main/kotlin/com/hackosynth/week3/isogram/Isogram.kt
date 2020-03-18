package com.hackosynth.week3.isogram

object Isogram {

    // for fun
    fun isIsogram(input: String): Boolean {
        return input
            .filter { it.isLetter() }
            .fold(HashMap(), mappieFoldFun())
            .filterValues { it > 1 }
            .isEmpty()
    }

    private fun mappieFoldFun(): (HashMap<Char, Int>, Char) -> HashMap<Char, Int> =
        { acc, char ->
            acc.compute(char.toUpperCase()) { c, i -> (i ?: 0) + 1 };
            acc
        }

    // for the need of speeeeed...
    fun isIsogram2(input: String): Boolean {
        val lettersSeen = HashSet<Char>()

        input
            .filter { it.isLetter() }
            .forEach {
                val upperCase = it.toUpperCase()
                if (lettersSeen.contains(upperCase)) {
                    return false
                } else {
                    lettersSeen.add(upperCase)
                }
            }

        return true
    }
}