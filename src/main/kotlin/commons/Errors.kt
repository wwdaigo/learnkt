package commons

/**
 * Created by daigomatsuoka on 17/06/17.
 */

enum class Errors(val description: String) {
    NO_DIMENSIONAL_MATRIX("NO_DIMENSIONAL_MATRIX"),
    COLS_DONT_MATCH("COLS_DONT_MATCH")
}

fun throwError(error: Errors) {
    Throwable(error.description).printStackTrace()
}