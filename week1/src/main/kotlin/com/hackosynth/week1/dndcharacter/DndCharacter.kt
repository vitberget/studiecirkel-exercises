package com.hackosynth.week1.dndcharacter

import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.random.Random

class DndCharacter {
    val strength: Int = generateAbilityScore()
    val dexterity: Int = generateAbilityScore()
    val constitution: Int = generateAbilityScore()
    val intelligence: Int = generateAbilityScore()
    val wisdom: Int = generateAbilityScore()
    val charisma: Int = generateAbilityScore()
    val hitpoints: Int = 10 + getAbilityModifier(constitution)

    companion object {
        /**
         * Generates an ability score following the rules for rolling ability scores in DnD
         * @return the generated score
         */
        fun generateAbilityScore(): Int =
            (1..4)
                .map { Random.nextInt(1, 7) }
                .sorted()
                .drop(1)
                .sum()
        /**
         * Returns the modifier that a given ability score would have
         * @param score - the ability score
         * @return the modifier for the given score
         */
        fun getAbilityModifier(score: Int): Int = floor((score - 10) / 2.0).roundToInt()
    }
}