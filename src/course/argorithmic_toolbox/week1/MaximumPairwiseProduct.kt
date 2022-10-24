package course.argorithmic_toolbox.week1

import java.math.BigInteger
import kotlin.random.Random

/**
 * naive solution
 */
fun maximumPairwiseProductNaive(
    list: List<BigInteger>,
): BigInteger {
    var result = BigInteger.valueOf(0)
    list.forEachIndexed { index, bigInteger1 ->
        for (i in index + 1..list.lastIndex) {
            val product = bigInteger1 * list[i]
            if (result < product) {
                result = product
            }
        }
    }
    return result
}

/**
 * two pointer solution
 */
fun maximumPairwiseProductTwoPointer(
    list: List<BigInteger>,
): BigInteger {
    var largest = BigInteger.ZERO
    var secondLargest = BigInteger.ZERO
    list.forEach {
        if (it > largest) {
            secondLargest = largest
            largest = it
        } else if (it > secondLargest) {
            secondLargest = it
        }
    }
    return largest * secondLargest
}

fun main() {
    for (i in 0..100) {
        val success = driver(
            method1 = ::maximumPairwiseProductNaive,
            method2 = ::maximumPairwiseProductTwoPointer,
            input = listOf(BigInteger.TWO, BigInteger.TWO)
        )
        if (!success) {
            println("Failed !!!")
            break
        }
    }
}

fun driver(
    method1: (list: List<BigInteger>) -> BigInteger,
    method2: ((list: List<BigInteger>) -> BigInteger)? = null,
    input: List<BigInteger> = getInput(),
): Boolean {
    println("Input: $input")

    val startTime1 = System.currentTimeMillis()
    val result1 = method1(input)
    val timeTaken1 = System.currentTimeMillis() - startTime1
    println("Time Taken 1: $timeTaken1")
    println("Result 1: $result1")

    if (method2 == null) {
        return true
    }

    val startTime2 = System.currentTimeMillis()
    val result2 = method2(input)
    val timeTaken2 = System.currentTimeMillis() - startTime2
    println("Time Taken 2: $timeTaken2")
    println("Result 2: $result2")
    println()

    return result1 == result2
}

fun getInput(): List<BigInteger> {
    // return readLine()!!.split(' ').map { it.toBigInteger() }

    val list = mutableListOf<Int>()
    for (i in 0..5) {
        list.add(Random.nextInt(2, 100))
    }
    return list.map {
        it.toBigInteger()
    }
}
