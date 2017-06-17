package type

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

    private fun isValidDimension(vararg values: Array<Double>): Boolean {
        if (values.isEmpty()) return false

        var numCols = 0
        for (row in values) {
            if (numCols == 0) numCols = row.size
            else if (numCols != row.size) return false
        }

        return true
    }

    private fun parseStringToArray(values: String) {
        val lines = values.split(":")

        if (lines.)
        rows = lines.size
        val cols = lines.joinToString(",").split(",")

    }
}

fun main(args: Array<String>) {


    val m = Matrix("12,13,14:14,16,18")

    val s = m + m
    println(s[0,0])



    val n = Matrix(3, 2)
    println(n[1,1])
    n[1,1] = 2.0
    println(n[1,1])
}

