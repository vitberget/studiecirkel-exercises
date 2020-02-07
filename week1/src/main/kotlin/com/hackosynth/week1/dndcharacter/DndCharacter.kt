package com.hackosynth.week1.dndcharacter

class DndCharacter {
    val strength: Int = TODO()
    val dexterity: Int = TODO()
    val constitution: Int = TODO()
    val intelligence: Int = TODO()
    val wisdom: Int = TODO()
    val charisma: Int = TODO()
    val hitpoints: Int = TODO()

    companion object {
        /**
         * Generates an ability score following the rules for rolling ability scores in DnD
         * @return the generated score
         */
        fun generateAbilityScore(): Int = TODO()

        /**
         * Returns the modifier that a given ability score would have
         * @param score - the ability score
         * @return the modifier for the given score
         */
        fun getAbilityModifier(score: Int): Int = TODO()
    }
}