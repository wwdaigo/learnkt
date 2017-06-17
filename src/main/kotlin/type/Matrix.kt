package type

import commons.Errors
import commons.throwError

/**
 * Created by daigomatsuoka on 16/06/17.
 */

class Matrix(valuesStr: String) {

    private var rows = 0
    private var cols = 0
    private var matrixValues: Array<Double> = Array(0, { 0.0 })

    init {
        parseStringToArray(valuesStr)
    }

    operator fun get (x: Int, y: Int): Double {
        TODO()
    }

    operator fun set(x: Int, y: Int, value: Double) {
        TODO()
    }


    operator fun plus(matrix: Matrix): Matrix {
        TODO()
    }

    operator fun minus(matrix: Matrix): Matrix {
        TODO()
    }

    val det: Double
    get() {
        TODO()
    }

    val T: Matrix
    get() {
        TODO()
    }

    val shape: String
    get() {
        TODO()
    }

    private fun parseStringToArray(values: String) {
        val lines = values.split(":")

        if (lines.isEmpty()) {
            throwError(Errors.NO_DIMENSIONAL_MATRIX)
            return
        }

        rows = lines.size
        val colValues = lines.joinToString(",").split(",")
        cols = colValues.size / rows

        if (rows * cols != colValues.size) {
            throwError(Errors.COLS_DONT_MATCH)
            return
        }

        matrixValues = Array(colValues.size, { 0.0 })

        colValues.forEachIndexed { index, v ->
            matrixValues[index] = v.trim().toDouble()
        }
    }
}

fun main(args: Array<String>) {

    val m = Matrix("12,13,14:14,16,18")

    println(m)
}

