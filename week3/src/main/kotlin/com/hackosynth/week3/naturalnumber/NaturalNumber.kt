package com.hackosynth.week3.naturalnumber

import com.hackosynth.week3.naturalnumber.Classification.*

enum class Classification {
    DEFICIENT,
    PERFECT,
    ABUNDANT
}

object NaturalNumber {
    fun classify(naturalNumber: Int): Classification {
        require(naturalNumber > 0)

        val factorSum = sumFactors(naturalNumber)

        return when {
            factorSum == naturalNumber -> PERFECT
            factorSum < naturalNumber -> DEFICIENT
            else -> ABUNDANT
        }
    }

    private fun sumFactors(number: Int): Int =
        (1..number.div(2))
            .filter { number % it == 0 }
            .sum()
}