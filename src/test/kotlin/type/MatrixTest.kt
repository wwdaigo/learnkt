package type

import commons.Errors
import commons.exceptions.MatrixException
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.matchers.startWith
import org.junit.Test

/**
 * Created by daigomatsuoka on 17/06/17.
 */


class MatrixTest {

    @Test
    fun matrixCreationSuccessfully() {
        val param = "1, 2: 3, 4"
        val matrix = Matrix(param)

        assert(matrix[0,0] == 1.0, { "[0,0] should be 1.0 but it was ${matrix[0,0]}" })
        assert(matrix[0,1] == 2.0, { "[0,1] should be 2.0 but it was ${matrix[0,1]}" })
        assert(matrix[1,0] == 3.0, { "[1,0] should be 3.0 but it was ${matrix[1,0]}" })
        assert(matrix[1,1] == 4.0, { "[1,1] should be 4.0 but it was ${matrix[1,1]}" })
    }

    @Test
    fun matrixCreationWithWrongDimensions() {
        val param = "1, 2: 3, 4, 5"
        val exception = shouldThrow<MatrixException> {
            Matrix(param)
        }
        assert(exception.message == Errors.COLS_DONT_MATCH.description)
    }

    @Test
    fun matrixCreationWithWrongCreator() {
        val param = "1, 2: 3, A"
        val exception = shouldThrow<MatrixException> {
            Matrix(param)
        }
        assert(exception.message == Errors.MATRIX_WRONG_CREATOR.description)
    }

    @Test
    fun matrixCreationWithNoDimensionData() {
        val param = ""
        val exception = shouldThrow<MatrixException> {
            Matrix(param)
        }
        assert(exception.message == Errors.NO_DIMENSIONAL_MATRIX.description)
    }

    @Test
    fun sumMatrixWithSameSize() {
        val matrix1 = Matrix("1,2:3,4")
        val matrix2 = Matrix("5,6:7,8")
        val sum = matrix1 + matrix2

        assert(sum[0,0] == 6.0, { "[0,0] should be 6.0 but it was ${sum[0,0]}" })
        assert(sum[0,1] == 8.0, { "[0,1] should be 8.0 but it was ${sum[0,1]}" })
        assert(sum[1,0] == 10.0, { "[1,0] should be 10.0 but it was ${sum[1,0]}" })
        assert(sum[1,1] == 12.0, { "[1,1] should be 12.0 but it was ${sum[1,1]}" })
    }

    @Test
    fun sumMatrixWithDifferentSizes() {
        val matrix1 = Matrix("1,2:3,4")
        val matrix2 = Matrix("1:2")

        val exception = shouldThrow<MatrixException> {
            matrix1 + matrix2
        }
        assert(exception.message == Errors.SIZES_SHOULD_MATCH.description)
    }

    @Test
    fun subtractMatrixWithSameSize() {

    }

    @Test
    fun subtractMatrixWithDifferentSizes() {

    }

    @Test
    fun associativeMultiplicationMatrixWithSameSize() {

    }

    @Test
    fun associativeMultiplicationMatrixWithDifferentSizes() {

    }

    @Test
    fun scalarMultiplicationMatrix() {

    }

    @Test
    fun dotMultiplicationMatrixWithSameSize() {

    }

    @Test
    fun dotMultiplicationMatrixWithDifferentSizes() {

    }

    @Test
    fun divideMatrixWithDifferentSizes() {

    }

    @Test
    fun associativeDivisionMatrixWithSameSize() {

    }

    @Test
    fun associativeDivisionMatrixWithDifferentSizes() {

    }

    @Test
    fun divisionMatrixWithSameSize() {

    }

    @Test
    fun divisionMatrixWithDifferentSizes() {

    }

    @Test
    fun scalarDivisionMatrixWithSameSize() {

    }

    @Test
    fun scalarDivisionMatrixWithDifferentSizes() {

    }

    @Test
    fun equalityBetweenTwoMatrices() {

    }

    @Test
    fun inequalityBetweenTwoMatrices() {

    }

    @Test
    fun matrixShape() {

    }

    @Test
    fun stringRepresentationOutput() {

    }

    @Test
    fun forEachMatrixIteration() {

    }

    @Test
    fun inversedMatrix() {

    }

    @Test
    fun transposedMatrix() {

    }

    @Test
    fun determinantWithNoSquaredMatrix() {

    }

    @Test
    fun determinantWithSquaredMatrix() {

    }
}