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
        val matrix1 = Matrix("5,6:7,8")
        val matrix2 = Matrix("1,2:3,4")

        val diff = matrix1 - matrix2

        assert(diff[0,0] == 4.0, { "[0,0] should be 4.0 but it was ${diff[0,0]}" })
        assert(diff[0,1] == 4.0, { "[0,1] should be 4.0 but it was ${diff[0,1]}" })
        assert(diff[1,0] == 4.0, { "[1,0] should be 4.0 but it was ${diff[1,0]}" })
        assert(diff[1,1] == 4.0, { "[1,1] should be 4.0 but it was ${diff[1,1]}" })
    }

    @Test
    fun subtractMatrixWithDifferentSizes() {
        val matrix1 = Matrix("1,2:3,4")
        val matrix2 = Matrix("1:2")

        val exception = shouldThrow<MatrixException> {
            matrix1 - matrix2
        }
        assert(exception.message == Errors.SIZES_SHOULD_MATCH.description)
    }

    @Test
    fun associativeMultiplicationMatrixWithSameSize() {
        val matrix1 = Matrix("5,6:7,8")
        val matrix2 = Matrix("1,2:3,4")

        val times = matrix1 * matrix2

        assert(times[0,0] == 5.0, { "[0,0] should be 5.0 but it was ${times[0,0]}" })
        assert(times[0,1] == 12.0, { "[0,1] should be 12.0 but it was ${times[0,1]}" })
        assert(times[1,0] == 21.0, { "[1,0] should be 21.0 but it was ${times[1,0]}" })
        assert(times[1,1] == 32.0, { "[1,1] should be 32.0 but it was ${times[1,1]}" })
    }

    @Test
    fun associativeMultiplicationMatrixWithDifferentSizes() {
        val matrix1 = Matrix("1,2:3,4")
        val matrix2 = Matrix("1:2")

        val exception = shouldThrow<MatrixException> {
            matrix1 * matrix2
        }
        assert(exception.message == Errors.SIZES_SHOULD_MATCH.description)
    }

    @Test
    fun scalarMultiplicationMatrix() {
        val matrix = Matrix("1,2:3,4")
        val prod = matrix * 2.0

        assert(prod[0,0] == 2.0, { "[0,0] should be 2.0 but it was ${prod[0,0]}" })
        assert(prod[0,1] == 4.0, { "[0,1] should be 4.0 but it was ${prod[0,1]}" })
        assert(prod[1,0] == 6.0, { "[1,0] should be 6.0 but it was ${prod[1,0]}" })
        assert(prod[1,1] == 8.0, { "[1,1] should be 8.0 but it was ${prod[1,1]}" })
    }

    @Test
    fun dotMultiplicationMatrixWithCorrectDimensions() {
        val matrix1 = Matrix("1,2:3,4:5,6")
        val matrix2 = Matrix("7,8,9:10,11,12")

        val dot = matrix1.dot(matrix2)

        assert(dot[0,0] == 27.0, { "[0,0] should be 27.0 but it was ${dot[0,0]}" })
        assert(dot[0,1] == 30.0, { "[0,1] should be 30.0 but it was ${dot[0,1]}" })
        assert(dot[0,2] == 33.0, { "[1,0] should be 33.0 but it was ${dot[0,2]}" })

        assert(dot[1,0] == 61.0, { "[0,0] should be 61.0 but it was ${dot[1,0]}" })
        assert(dot[1,1] == 68.0, { "[0,1] should be 68.0 but it was ${dot[1,1]}" })
        assert(dot[1,2] == 75.0, { "[1,0] should be 75.0 but it was ${dot[1,2]}" })

        assert(dot[2,0] == 95.0, { "[0,0] should be 95.0 but it was ${dot[2,0]}" })
        assert(dot[2,1] == 106.0, { "[0,1] should be 106.0 but it was ${dot[2,1]}" })
        assert(dot[2,2] == 117.0, { "[1,0] should be 117.0 but it was ${dot[2,2]}" })
    }

    @Test
    fun dotMultiplicationMatrixWithIncorrectDimensions() {
        val matrix = Matrix("1,2:3,4")

        val exception = shouldThrow<MatrixException> {
            matrix.dot(matrix)
        }
        assert(exception.message == Errors.SHAPES_NOT_ALIGNED.description)
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