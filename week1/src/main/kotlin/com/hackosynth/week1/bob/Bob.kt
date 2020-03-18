package com.hackosynth.week1.bob

object Bob {
    /**
     * Returns bob's very well worded response to a given input.
     * @param input - the sentence spoken to bob
     * @return bob's response to the spoken sentence
     */
    fun hey(input: String): String =
        when {
            input.isBlank() -> "Fine. Be that way!"
            input.contains("!") && input.contains("?") -> "Calm down, I know what I'm doing!"
            input.contains("!")  -> "Whoa, chill out!"
            input.contains("?") -> "Sure."

            else -> "Whatever"
        }
}