package type

import commons.Errors
import commons.throwError
import java.awt.color.ColorSpace

/**
 * Created by daigomatsuoka on 16/06/17.
 */

class Matrix {

    private var rows = 0
    private var cols = 0
    private var matrixValues: Array<Double> = Array(0, { 0.0 })

    constructor(valuesStr: String) {
        parseStringToArray(valuesStr)
    }

    private constructor(rows: Int, cols: Int, values: Array<Double>) {
        this.rows = rows
        this.cols = cols
        this.matrixValues = values
    }

    /**
     * OPERATORS OVERRIDE
     */

    operator fun get (x: Int, y: Int): Double {
        return matrixValues[realIndex(x, y)]
    }

    operator fun set(x: Int, y: Int, value: Double) {
        matrixValues[realIndex(x, y)] = value
    }

    operator fun plus(matrix: Matrix): Matrix {
        val bothMatrices = matrixValues.zip(matrix.matrixValues)
        val resultMatrix = Array(rows * cols, {0.0})

        bothMatrices.forEachIndexed { index, pair ->
            resultMatrix[index] = pair.first + pair.second
        }

        return Matrix(rows, cols, resultMatrix)
    }

    operator fun minus(matrix: Matrix): Matrix {
        TODO()
    }

    operator fun times(matrix: Matrix): Matrix {
        TODO()
    }

    operator fun times(scalar: Double): Matrix {
        TODO()
    }

    operator fun div(matrix: Matrix): Matrix {
        TODO()
    }

    operator fun div(scalar: Double): Matrix {
        TODO()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    /**
     * LIST METHODS
     */

    fun forEach(action: (i: Int, j: Int, value: Double) -> Unit) {
        var row = 0
        var col = 0
        matrixValues.forEachIndexed { index, d ->
            col = index % cols
            if (index % cols == 0 && index > 0) row ++

            action(row, col, d)
        }
    }

    fun dot(matrix: Matrix): Matrix {
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

    val shape: Pair<Int, Int>
    get() = Pair<Int, Int>(rows, cols)

    override fun toString(): String {
        var s = ""
        matrixValues.forEachIndexed { index, d ->
           s += d.toString() + if ((index + 1) % cols == 0) "\n" else ", "
        }
        return s
    }

    /**
     * PRIVATE METHODS
     */

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

    private fun realIndex(x: Int, y: Int): Int = x * cols + rows
}

fun main(args: Array<String>) {

    val m = Matrix("12,13,14:14,16,18")
    val n = Matrix("1,1,1:1,1,1")


    println(m + n)
}

