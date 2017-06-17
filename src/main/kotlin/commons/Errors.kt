package commons

import commons.exceptions.MatrixException

/**
 * Created by daigomatsuoka on 17/06/17.
 */

enum class Errors(val description: String) {
    MATRIX_WRONG_CREATOR("MATRIX_WRONG_CREATOR"),
    NO_DIMENSIONAL_MATRIX("NO_DIMENSIONAL_MATRIX"),
    SIZES_SHOULD_MATCH("SIZES_SHOULD_MATCH"),
    COLS_DONT_MATCH("COLS_DONT_MATCH")
}

fun throwError(error: Errors) {
    throw MatrixException(error)
}