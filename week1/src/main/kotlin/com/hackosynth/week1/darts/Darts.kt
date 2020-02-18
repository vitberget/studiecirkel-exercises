package com.hackosynth.week1.darts

import kotlin.math.sqrt

object Darts {
    /**
     * Given the x and y coordinates returns the score a dart landing there would yield
     * @param x - the X coordinate
     * @param y - the Y coordinate
     * @return the score the given coordinates would yield
     */
    fun score(x: Number, y: Number): Int {
        val xd = x.toDouble()
        val yd = y.toDouble()
        val radius = sqrt(xd * xd + yd * yd)

        return when {
            radius <= 1.0 -> 10
            radius <= 5.0 -> 5
            radius <= 10.0 -> 1
            else -> 0
        }
    }
}