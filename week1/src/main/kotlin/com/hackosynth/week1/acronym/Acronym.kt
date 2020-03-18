package com.hackosynth.week1.acronym

object Acronym {
    /**
     * Generates an acronym form a given sentence
     * @return the acronym for the sentence
     */
    fun generate(phrase: String): String =
        phrase.split("""[\s-_]+""".toRegex())
            .map { it[0] }
            .map { it.toUpperCase() }
            .joinToString(separator = "")
}