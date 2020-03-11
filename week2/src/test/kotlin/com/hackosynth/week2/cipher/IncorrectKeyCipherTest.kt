package com.hackosynth.week2.cipher

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class IncorrectKeyCipherTest {
    @Test()
    fun  `key cannot consist of upper cased letters`() {
        assertThrows(IllegalArgumentException::class.java) {
            Cipher("ABCDEF")
        }
    }

    @Test()
    fun `key cannot contain upper cased letters`() {
        assertThrows(IllegalArgumentException::class.java) {
            Cipher("abcdEFg")
        }
    }

    @Test()
    fun `key cannot consist of digits`() {
        assertThrows(IllegalArgumentException::class.java) {
            Cipher("12345")
        }
    }

    @Test()
    fun `key cannot contain digits`() {
        assertThrows(IllegalArgumentException::class.java) {
            Cipher("abcd345ef")
        }
    }

    @Test()
    fun `key cannot be empty`() {
        assertThrows(IllegalArgumentException::class.java) {
            Cipher("")
        }
    }
}