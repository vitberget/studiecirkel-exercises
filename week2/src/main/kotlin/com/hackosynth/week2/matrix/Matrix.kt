package com.hackosynth.week2.matrix

class Matrix(matrixAsString: String) {

    val matrix: List<List<Int>> =
        matrixAsString
            .lines()
            .map { rowToInts(it) }

    private fun rowToInts(rowStr: String): List<Int> =
        rowStr.split("""\s+""".toRegex())
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }

    fun column(colNr: Int): List<Int> =
        matrix.map { it[colNr - 1] }

    fun row(rowNr: Int): List<Int> =
        matrix[rowNr - 1]
}