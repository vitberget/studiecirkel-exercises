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

        val mummy = mummify(naturalNumber)
        return when {
            mummy == naturalNumber -> PERFECT
            mummy < naturalNumber -> DEFICIENT
            else -> ABUNDANT
        }
    }

    fun mummify(naturalNumber: Int): Int =
        (1..(naturalNumber / 2))
            .filter { naturalNumber % it == 0 }
            .sum()
}