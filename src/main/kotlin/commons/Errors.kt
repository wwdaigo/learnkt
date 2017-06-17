package commons

/**
 * Created by daigomatsuoka on 17/06/17.
 */

enum class Errors(val description: String) {
    NO_DIMENSIONAL_MATRIX("")
}

fun throwError(error: Errors) {
    Throwable(error.description).printStackTrace()
}