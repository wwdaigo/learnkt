package commons.exceptions

import commons.Errors

/**
 * Created by daigomatsuoka on 17/06/17.
 */

class MatrixException(val error: Errors): Throwable() {

    override val message: String?
        get() = error.description
}