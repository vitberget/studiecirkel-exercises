package com.hackosynth.week1.dndcharacter

import com.hackosynth.week1.dndcharacter.DndCharacter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DndCharacterTest {

    @Test
    fun `ability modifier for score 3 is n4`() = assertEquals(-4, DndCharacter.getAbilityModifier(3))

    @Test
    fun `ability modifier for score 4 is n3`() = assertEquals(-3, DndCharacter.getAbilityModifier(4))

    @Test
    fun `ability modifier for score 5 is n3`() = assertEquals(-3, DndCharacter.getAbilityModifier(5))

    @Test
    fun `ability modifier for score 6 is n2`() = assertEquals(-2, DndCharacter.getAbilityModifier(6))

    @Test
    fun `ability modifier for score 7 is n2`() = assertEquals(-2, DndCharacter.getAbilityModifier(7))

    @Test
    fun `ability modifier for score 8 is n1`() = assertEquals(-1, DndCharacter.getAbilityModifier(8))

    @Test
    fun `ability modifier for score 9 is n1`() = assertEquals(-1, DndCharacter.getAbilityModifier(9))

    @Test
    fun `ability modifier for score 10 is 0`() = assertEquals(0, DndCharacter.getAbilityModifier(10))

    @Test
    fun `ability modifier for score 11 is 0`() = assertEquals(0, DndCharacter.getAbilityModifier(11))

    @Test
    fun `ability modifier for score 12 is 1`() = assertEquals(1, DndCharacter.getAbilityModifier(12))

    @Test
    fun `ability modifier for score 13 is 1`() = assertEquals(1, DndCharacter.getAbilityModifier(13))

    @Test
    fun `ability modifier for score 14 is 2`() = assertEquals(2, DndCharacter.getAbilityModifier(14))

    @Test
    fun `ability modifier for score 15 is 2`() = assertEquals(2, DndCharacter.getAbilityModifier(15))

    @Test
    fun `ability modifier for score 16 is 3`() = assertEquals(3, DndCharacter.getAbilityModifier(16))

    @Test
    fun `ability modifier for score 17 is 3`() = assertEquals(3, DndCharacter.getAbilityModifier(17))

    @Test
    fun `ability modifier for score 18 is 4`() = assertEquals(4, DndCharacter.getAbilityModifier(18))

    @Test
    fun `random ability is within range`() {
        val score = DndCharacter.generateAbilityScore()
        assertTrue(score in (3..18))
    }

    @Test
    fun `random character is valid`() {
        with(DndCharacter()) {
            assertTrue(strength in (3..18))
            assertTrue(dexterity in (3..18))
            assertTrue(constitution in (3..18))
            assertTrue(intelligence in (3..18))
            assertTrue(wisdom in (3..18))
            assertTrue(charisma in (3..18))
            assertEquals(10 + DndCharacter.getAbilityModifier(constitution), hitpoints)
        }
    }

    @Test
    fun `each ability is only calculated once`() {
        val char = DndCharacter()
        assertTrue(char.strength == char.strength)
    }
}