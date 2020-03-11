package com.hackosynth.week3.naturalnumber

import com.hackosynth.week3.naturalnumber.NaturalNumber.classify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class NaturalNumberTest {
    @Test
    fun `Small perfekt number is classified correctly`() {
        assertEquals(Classification.PERFECT, classify(6))
    }

    @Test
    fun `Medium perfect number is classified correctly`() {
        assertEquals(Classification.PERFECT, classify(28))
    }

    @Test
    fun `Large perfect number is classified correctly`() {
        assertEquals(Classification.PERFECT, classify(33550336))
    }

    @Test
    fun `Small abundant number is classified correctly`() {
        assertEquals(Classification.ABUNDANT, classify(12))
    }

    @Test
    fun `Medium abundant number is classified correctly`() {
        assertEquals(Classification.ABUNDANT, classify(30))
    }

    @Test
    fun `Large abundant number is classified correctly`() {
        assertEquals(Classification.ABUNDANT, classify(33550335))
    }

    @Test
    fun `Smallest prime deficient number is classified correctly`() {
        assertEquals(Classification.DEFICIENT, classify(2))
    }

    @Test
    fun `Smallest non prime deficient number is classified correctly`() {
        assertEquals(Classification.DEFICIENT, classify(4))
    }

    @Test
    fun `Medium number is classified correctly`() {
        assertEquals(Classification.DEFICIENT, classify(32))
    }

    @Test
    fun `Large deficient number is classified correctly`() {
        assertEquals(Classification.DEFICIENT, classify(33550337))
    }

    @Test
    fun `Edge case with no factors other than itself is classified correctly`() {
        assertEquals(Classification.DEFICIENT, classify(1))
    }

    @Test
    fun `Zero is not a natural number`() {
        assertThrows(RuntimeException::class.java) {
            classify(0)
        }
    }

    @Test
    fun `Negative number is not a natural number`() {
        assertThrows(RuntimeException::class.java) {
            classify(-1)
        }
    }
}