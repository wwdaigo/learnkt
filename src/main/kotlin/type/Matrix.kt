package type

/**
 * Created by daigomatsuoka on 16/06/17.
 */

class Matrix {

    var matrixValues: Array<Array<Double>> = Array(0, { emptyArray<Double>() })

    constructor(vararg values: Array<Double>) {

        if (isValidDimension(*values)) {
            matrixValues = Array(values.size, { emptyArray<Double>() })

            for ((index, line) in values.withIndex()) {
                matrixValues[index] = line
            }
        } else {
            Throwable("Columns size should match on each line").printStackTrace()
        }

    }

    constructor(rows: Int, cols: Int) {
        val line = Array<Double>(cols) { 0.0 }
        matrixValues = Array(rows, { line })
    }

    operator fun get (x: Int, y: Int): Double {
        return matrixValues[x][y]
    }

    operator fun set(x: Int, y: Int, value: Double) {
        matrixValues[x][y] = value
    }

/*
    operator fun plus(matrix: Matrix): Matrix {

    }

    operator fun minus(matrix: Matrix): Matrix {

    }*/


    private fun isValidDimension(vararg values: Array<Double>): Boolean {
        if (values.isEmpty()) return false

        var numCols = 0
        for (row in values) {
            if (numCols == 0) numCols = row.size
            else if (numCols != row.size) return false
        }

        return true
    }
}

fun main(args: Array<String>) {

    val m = Matrix(arrayOf(11.0, 12.0), arrayOf(13.1, 0.0))
    println(m[1, 1])

    val n = Matrix(3, 2)
    println(n[1,1])
    n[1,1] = 2.0
    println(n[1,1])
}

