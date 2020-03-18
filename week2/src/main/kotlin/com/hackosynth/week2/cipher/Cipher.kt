package com.hackosynth.week2.cipher

import java.lang.Math.floorMod

data class Cipher(val key: String = randomKey()) {

    init {
        if (key.isEmpty())
            throw IllegalAccessException()
        if (key.filter { it.isDigit() || it.isUpperCase() }
                .isNotEmpty())
            throw IllegalAccessException()
    }

    companion object {
        fun randomKey(): String = (1..100)
            .map { ('a'..'z').random() }
            .joinToString("")
    }

    private val keyInts = key.map { toWordInt(it) }

    fun encode(value: String): String = process(value, ::encodeLetter)
    fun decode(value: String): String = process(value, ::decodeLetter)

    private fun process(value: String, modderFn: (Int, Int) -> Int): String =
        value
            .map { toWordInt(it) }
            .mapIndexed { i, c -> modderFn(i, c) }
            .map { toWordChar(it) }
            .joinToString("")


    private fun encodeLetter(i: Int, c: Int): Int = c + keyInts[i % keyInts.size]
    private fun decodeLetter(i: Int, c: Int): Int = c - keyInts[i % keyInts.size]

    private fun toWordInt(c: Char): Int = c - 'a'
    private fun toWordChar(i: Int): Char = 'a' + floorMod(i, 26)
}

