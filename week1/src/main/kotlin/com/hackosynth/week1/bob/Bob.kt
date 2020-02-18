package com.hackosynth.week1.bob

object Bob {
    /**
     * Returns bob's very well worded response to a given input.
     * @param input - the sentence spoken to bob
     * @return bob's response to the spoken sentence
     */
    fun hey(input: String): String {
        return with(input.trimEnd()) {
            val silence = isEmpty()
            val asking = endsWith("?")
            val shouting = contains("\\p{Upper}".toRegex()) && !contains("\\p{Lower}".toRegex())

            when {
                silence -> "Fine. Be that way!"
                shouting && asking -> "Calm down, I know what I'm doing!"
                shouting -> "Whoa, chill out!"
                asking -> "Sure."
                else -> "Whatever."
            }
        }
    }
}