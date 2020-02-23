package com.hackosynth.week2.cipher

data class Cipher(var key: String = randomKey()) {
    companion object {
        fun randomKey(): String = TODO()
    }

    fun encode(value: String): String = TODO()
    fun decode(value: String): String = TODO()
}