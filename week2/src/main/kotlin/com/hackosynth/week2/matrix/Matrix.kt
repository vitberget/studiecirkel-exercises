package com.hackosynth.week2.matrix

class Matrix(private val matrixAsString: String) {
    private val integers by lazy {
        matrixAsString
            .split("\n")
            .map { it.trim() }
            .map { it.split("\\s+".toRegex()).map {digit -> digit.toInt() } }
    }

    fun column(colNr: Int): List<Int> = integers.map { it[colNr - 1] }
    fun row(rowNr: Int): List<Int> = integers[rowNr - 1]
}