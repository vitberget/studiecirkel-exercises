package com.hackosynth.week1.darts

import kotlin.math.pow

object Darts {
    /**
     * Given the x and y coordinates returns the score a dart landing there would yield
     * @param x - the X coordinate
     * @param y - the Y coordinate
     * @return the score the given coordinates would yield
     */

    fun score(x: Number, y: Number): Int {
        return when (x.toDouble().pow(2) + y.toDouble().pow(2)) {
            in 0.0..1.0 -> 10
            in 1.0..5.0.pow(2) -> 5
            in 5.0.pow(2)..10.0.pow(2) -> 1
            else -> 0
        }
    }
}
