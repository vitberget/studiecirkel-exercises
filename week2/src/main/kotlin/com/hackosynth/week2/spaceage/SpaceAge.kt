package com.hackosynth.week2.spaceage

import java.math.RoundingMode

class SpaceAge(val ageSeconds: Long) {
    companion object {
        private const val SECONDS_PER_EARTH_YEAR = 60 * 60 * 24 * 365.25
    }

    private fun Double.setScale(scale: Int): Double {
        return this.toBigDecimal().setScale(scale, RoundingMode.HALF_UP).toDouble()
    }

    fun onEarth(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.EARTH.earthYears)
    fun onMercury(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.MERCURY.earthYears)
    fun onVenus(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.VENUS.earthYears)
    fun onMars(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.MARS.earthYears)
    fun onJupiter(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.JUPITER.earthYears)
    fun onSaturn(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.SATURN.earthYears)
    fun onUranus(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.URANUS.earthYears)
    fun onNeptune(): Double = getSpaceAge(ageSeconds, OrbitalPeriod.NEPTUNE.earthYears)

    private fun getSpaceAge(seconds: Long, earthYears: Double): Double {
        return (seconds / SECONDS_PER_EARTH_YEAR / earthYears).setScale(2)
    }

    enum class OrbitalPeriod(val earthYears: Double) {
        EARTH(1.0),
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132)
    }
}