package type

/**
 * Created by daigomatsuoka on 16/06/17.
 */

class Vector(vararg compound: Double) {

    private var sequence: DoubleArray = kotlin.DoubleArray(compound.size)

    init {
        sequence = compound
    }

    val size: Int
        get() = sequence.size

    fun sum(vector: Vector) {

    }

}

fun main(args: Array<String>) {
    val vector = Vector(1.0, 3.1, 1.0)
    println(vector.size)
}