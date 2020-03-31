package com.hackosynth.week3.isogram

object Isogram {

    // for fun
    fun isIsogram(input: String): Boolean =
        input.filter { it.isLetter() }
            .map { it.toUpperCase() }
            .fold(HashMap(), mappieFoldFun())
            .filterValues { it > 1 }
            .isEmpty()

    private fun mappieFoldFun(): (HashMap<Char, Int>, Char) -> HashMap<Char, Int> =
        { acc, char ->
            acc.compute(char) { c, i -> (i ?: 0) + 1 }
            acc
        }

    // for the need of speeeeed?!?...
    fun isIsogram2(input: String): Boolean {
        val lettersSeen = HashSet<Char>()

        input.filter { it.isLetter() }
            .forEach {
                with(it.toUpperCase()) {
                    if (lettersSeen.contains(this)) {
                        return false // exit as soon as we have a duplicate letter
                    } else {
                        lettersSeen.add(this)
                    }
                }
            }

        return true
    }
}