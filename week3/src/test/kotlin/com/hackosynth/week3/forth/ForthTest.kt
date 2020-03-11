package com.hackosynth.week3.forth

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParsingAndNumbersTest {
    @Test
    fun `Numbers just get pushed onto the stack`() = assertIterableEquals(listOf(1, 2, 3, 4, 5), Forth.evaluate("1 2 3 4 5"))
}

class Addition {

    @Test
    fun `Can add two numbers`() = assertIterableEquals(listOf(3), Forth.evaluate("1 2 +"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("+")
        }
    }

    @Test
    fun `Errors if there is only one value on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("1 +")
        }
    }
}

class Subtraction {

    @Test
    fun `Can subtract two numbers`() = assertIterableEquals(listOf(-1), Forth.evaluate("3 4 -"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("-")
        }
    }

    @Test
    fun `Errors if there is only one value on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("1 -")
        }
    }
}

class Multiplication {

    @Test
    fun `Can multiply two numbers`() = assertIterableEquals(listOf(8), Forth.evaluate("2 4 *"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("*")
        }
    }

    @Test
    fun `Errors if there is only one value on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("1 *")
        }
    }
}

class Division {

    @Test
    fun `Can divide two numbers`() = assertIterableEquals(listOf(4), Forth.evaluate("12 3 /"))

    @Test
    fun `Performs integer division`() = assertIterableEquals(listOf(2), Forth.evaluate("8 3 /"))

    @Test
    fun `Errors if dividing by zero`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("4 0 /")
        }
    }

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("/")
        }
    }

    @Test
    fun `Errors if there is only one value on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("1 /")
        }
    }
}

class CombinedArithmetic {

    @Test
    fun `Addition and subtraction`() = assertIterableEquals(listOf(-1), Forth.evaluate("1 2 + 4 -"))

    @Test
    fun `Multiplication and division`() = assertIterableEquals(listOf(2), Forth.evaluate("2 4 * 3 /"))
}

class Dup {

    @Test
    fun `Copies a value on the stack`() = assertIterableEquals(listOf(1, 1), Forth.evaluate("1 dup"))

    @Test
    fun `Copies the top value on the stack`() = assertIterableEquals(listOf(1, 2, 2), Forth.evaluate("1 2 dup"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("dup")
        }
    }
}

class Drop {

    @Test
    fun `Removes the top value on the stack if it is the only one`() = assertIterableEquals(listOf<Int>(), Forth.evaluate("1 drop"))

    @Test
    fun `Removes the top value on the stack if it is not the only one`() = assertIterableEquals(listOf(1), Forth.evaluate("1 2 drop"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("drop")
        }
    }
}

class Swap {

    @Test
    fun `Swaps the top two values on the stack if they are the only ones`() = assertIterableEquals(listOf(2, 1), Forth.evaluate("1 2 swap"))

    @Test
    fun `Swaps the top two values on the stack if they are not the only ones`() = assertIterableEquals(listOf(1, 3, 2), Forth.evaluate("1 2 3 swap"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("swap")
        }
    }

    @Test
    fun `Errors if there is only one value on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("1 swap")
        }
    }
}

class Over {

    @Test
    fun `Copies the second element if there are only two`() = assertEquals(listOf(1, 2, 1), Forth.evaluate("1 2 over"))

    @Test
    fun `Copies the second element if there are more than two`() = assertEquals(listOf(1, 2, 3, 2), Forth.evaluate("1 2 3 over"))

    @Test
    fun `Errors if there is nothing on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("over")
        }
    }

    @Test
    fun `Errors if there is only one value on the stack`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("1 over")
        }
    }
}

class UserDefinedWords {

    @Test
    fun `Can consist of built-in words`() = assertIterableEquals(listOf(1, 1, 1), Forth.evaluate(": dup-twice dup dup ;", "1 dup-twice"))

    @Test
    fun `Execute in the right order`() = assertIterableEquals(listOf(1, 2, 3), Forth.evaluate(": countup 1 2 3 ;", "countup"))

    @Test
    fun `Can override other user-defined words`() = assertIterableEquals(listOf(1, 1, 1), Forth.evaluate(": foo dup ;", ": foo dup dup ;", "1 foo"))

    @Test
    fun `Can override built-in words`() = assertIterableEquals(listOf(1, 1), Forth.evaluate(": swap dup ;", "1 swap"))

    @Test
    fun `Can override built-in operators`() = assertIterableEquals(listOf(12), Forth.evaluate(": + * ;", "3 4 +"))

    @Test
    fun `Can use different words with the same name`() = assertIterableEquals(listOf(5, 6), Forth.evaluate(": foo 5 ;", ": bar foo ;", ": foo 6 ;", "bar foo"))

    @Test
    fun `Can define word that uses word with the same name`() = assertIterableEquals(listOf(11), Forth.evaluate(": foo 10 ;", ": foo foo 1 + ;", "foo"))

    @Test
    fun `Cannot redefine numbers`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate(": 1 2 ;")
        }
    }

    @Test
    fun `Errors if executing a non-existent word`() {
        assertThrows(RuntimeException::class.java) {
            Forth.evaluate("foo")
        }
    }
}

class CaseInsensitivity {

    @Test
    fun `DUP is case-insensitive`() = assertIterableEquals(listOf(1, 1, 1, 1), Forth.evaluate("1 DUP Dup dup"))

    @Test
    fun `DROP is case-insensitive`() = assertIterableEquals(listOf(1), Forth.evaluate("1 2 3 4 DROP Drop drop"))

    @Test
    fun `SWAP is case-insensitive`() = assertIterableEquals(listOf(2, 3, 4, 1), Forth.evaluate("1 2 SWAP 3 Swap 4 swap"))

    @Test
    fun `OVER is case-insensitive`() = assertIterableEquals(listOf(1, 2, 1, 2, 1), Forth.evaluate("1 2 OVER Over over"))

    @Test
    fun `User-defined words are case-insensitive`() = assertIterableEquals(listOf(1, 1, 1, 1), Forth.evaluate(": foo dup ;", "1 FOO Foo foo"))

    @Test
    fun `Definitions are case-insensitive`() = assertIterableEquals(listOf(1, 1, 1, 1), Forth.evaluate(": SWAP DUP Dup dup ;", "1 swap"))
}
