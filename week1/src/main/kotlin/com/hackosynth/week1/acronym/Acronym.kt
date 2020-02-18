package com.hackosynth.week1.acronym

object Acronym {
    /**
     * Generates an acronym form a given sentence
     * @return the acronym for the sentence
     */
    fun generate(phrase: String): String = phrase.split(" ", "-").map { word ->
        word.firstOrNull { it.isLetterOrDigit() } ?: ""
    }.joinToString("").toUpperCase()
}