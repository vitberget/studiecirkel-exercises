package com.hackosynth.week3.diamond

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

class DiamondTest {
    @Test
    fun `Test one by one diamond`() {
        val output = Diamond.printToList('A')
        assertIterableEquals(output, listOf("A"))
    }

    @Test
    fun `Test two by two diamond`() {
        val output = Diamond.printToList('B')
        assertIterableEquals(output, listOf(
            " A ",
            "B B",
            " A "))
    }

    @Test
    fun `Test three by three diamond`() {
        val output = Diamond.printToList('C')
        assertIterableEquals(output, listOf(
            "  A  ",
            " B B ",
            "C   C",
            " B B ",
            "  A  "))
    }

    @Test
    fun `Test five by five diamond`() {
        val output = Diamond.printToList('E')
        assertIterableEquals(output, listOf(
            "    A    ",
            "   B B   ",
            "  C   C  ",
            " D     D ",
            "E       E",
            " D     D ",
            "  C   C  ",
            "   B B   ",
            "    A    "))
    }

    @Test
    fun `Test full diamond`() {
        val output = Diamond.printToList('Z')
        assertIterableEquals(output, listOf(
            "                         A                         ",
            "                        B B                        ",
            "                       C   C                       ",
            "                      D     D                      ",
            "                     E       E                     ",
            "                    F         F                    ",
            "                   G           G                   ",
            "                  H             H                  ",
            "                 I               I                 ",
            "                J                 J                ",
            "               K                   K               ",
            "              L                     L              ",
            "             M                       M             ",
            "            N                         N            ",
            "           O                           O           ",
            "          P                             P          ",
            "         Q                               Q         ",
            "        R                                 R        ",
            "       S                                   S       ",
            "      T                                     T      ",
            "     U                                       U     ",
            "    V                                         V    ",
            "   W                                           W   ",
            "  X                                             X  ",
            " Y                                               Y ",
            "Z                                                 Z",
            " Y                                               Y ",
            "  X                                             X  ",
            "   W                                           W   ",
            "    V                                         V    ",
            "     U                                       U     ",
            "      T                                     T      ",
            "       S                                   S       ",
            "        R                                 R        ",
            "         Q                               Q         ",
            "          P                             P          ",
            "           O                           O           ",
            "            N                         N            ",
            "             M                       M             ",
            "              L                     L              ",
            "               K                   K               ",
            "                J                 J                ",
            "                 I               I                 ",
            "                  H             H                  ",
            "                   G           G                   ",
            "                    F         F                    ",
            "                     E       E                     ",
            "                      D     D                      ",
            "                       C   C                       ",
            "                        B B                        ",
            "                         A                         "))
    }
}