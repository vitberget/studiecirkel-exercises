package com.hackosynth.week1.bob

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BobTest {

    @Test
    fun `stating something`() {
        assertEquals("Whatever.", Bob.hey("Tom-ay-to, tom-aaaah-to."))
    }

    @Test
    fun shouting() {
        assertEquals("Whoa, chill out!", Bob.hey("WATCH OUT!"))
    }

    @Test
    fun `shouting gibberish`() {
        assertEquals("Whoa, chill out!", Bob.hey("FCECDFCAAB"))
    }

    @Test
    fun `asking a question`() {
        assertEquals("Sure.", Bob.hey("Does this cryogenic chamber make me look fat?"))
    }

    @Test
    fun `asking a numeric question`() {
        assertEquals("Sure.", Bob.hey("You are, what, like 15?"))
    }

    @Test
    fun `asking gibberish`() {
        assertEquals("Sure.", Bob.hey("fffbbcbeab?"))
    }

    @Test
    fun `talking forcefully`() {
        assertEquals("Whatever.", Bob.hey("Let's go make out behind the gym!"))
    }

    @Test
    fun `using acronyms in regular speech`() {
        assertEquals("Whatever.", Bob.hey("It's OK if you don't want to go to the DMV."))
    }

    @Test
    fun `forceful question`() {
        assertEquals("Calm down, I know what I'm doing!", Bob.hey("WHAT THE HELL WERE YOU THINKING?"))
    }

    @Test
    fun `shouting numbers`() {
        assertEquals("Whoa, chill out!", Bob.hey("1, 2, 3 GO!"))
    }

    @Test
    fun `no letters`() {
        assertEquals("Whatever.", Bob.hey("1, 2, 3"))
    }

    @Test
    fun `question with no letters`() {
        assertEquals("Sure.", Bob.hey("4?"))
    }

    @Test
    fun `shouting with special characters`() {
        assertEquals("Whoa, chill out!", Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
    }

    @Test
    fun `shouting with no exclamation mark`() {
        assertEquals("Whoa, chill out!", Bob.hey("I HATE THE DMV"))
    }

    @Test
    fun `statement containing question mark`() {
        assertEquals("Whatever.", Bob.hey("Ending with ? means a question."))
    }

    @Test
    fun `non letters with question`() {
        assertEquals("Sure.", Bob.hey(":) ?"))
    }

    @Test
    fun `prattling on`() {
        assertEquals("Sure.", Bob.hey("Wait! Hang on. Are you going to be OK?"))
    }

    @Test
    fun silence() {
        assertEquals("Fine. Be that way!", Bob.hey(""))
    }

    @Test
    fun `prolonged silence`() {
        assertEquals("Fine. Be that way!", Bob.hey("          "))
    }

    @Test
    fun `alternate silence`() {
        assertEquals("Fine. Be that way!", Bob.hey("\t\t\t\t\t\t\t\t\t\t"))
    }

    @Test
    fun `multiple line question`() {
        assertEquals("Whatever.", Bob.hey("\nDoes this cryogenic chamber make me look fat?\nno"))
    }

    @Test
    fun `starting with whitespace`() {
        assertEquals("Whatever.", Bob.hey("         hmmmmmmm..."))
    }

    @Test
    fun `ending with whitespace`() {
        assertEquals("Sure.", Bob.hey("Okay if like my  spacebar  quite a bit?   "))
    }

    @Test
    fun `other whitespace`() {
        assertEquals("Fine. Be that way!", Bob.hey("\n\r \t"))
    }

    @Test
    fun `non question ending with whitespace`() {
        assertEquals("Whatever.", Bob.hey("This is a statement ending with whitespace      "))
    }
}