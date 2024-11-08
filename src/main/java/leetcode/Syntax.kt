package leetcode

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.pow

/**
 * Set<Char> from a String
 */
val chars = "Temp".toSet()

/**
 * To clone an array
 */
val array1 = intArrayOf(1, 2, 3)
val cloneArray = array1.clone()

/**
 * To count number of 1 bit in binary representation.
 */
const val value: Int = 123
val bitsCount: Int = value.countOneBits()

/**
 * To count leading zero bits
 */
val leadingZeroBitCount: Int = value.countLeadingZeroBits()

/**
 * To get number of binary digits of a number
 */
fun numberOfBinaryDigits(n: Int): Int {
    if (n == 0) return 1  // Special case: 0 has 1 binary digit (just "0")
    return 32 - n.countLeadingZeroBits()
}

/**
 * To get if ith bit of a number is set
 */
fun checkIthBitIsSet(n: Int, i: Int): Boolean {
    return (n and (1 shl i)) != 0
}

/**
 * To insert at start of string builder
 */
fun appendAtStart() {
    val stringBuilder = StringBuilder()
    stringBuilder.insert(0, 5)
}

const val ASCII_CAPITAL_A = 65
const val ASCII_SMALL_A = 97

/**
 * Priority queue decreasing order
 */
fun priorityQueueDescendingOrder() {
    val pq = PriorityQueue { a: Int, b: Int ->
        b - a
    }
}

/**
 * Maths
 */
fun mathOperations() {
    /**
     * Power
     */
    val a = 5
    val b = 8
    val aPowerB = a.toDouble().pow(b)

    /**
     * Absolute value
     */
    val c = -6
    val d = abs(c)
}

fun bitwiseOperations() {
    val a = 5
    val b = 8
    val or = a or b
    val and = a and b
    val xor = a xor b
}

fun logicalOperations() {
    val a = true
    val b = false
    val or = a || b
    val and = a && b
    val not = !a
}

fun maths() {
    /**
     * Sum of first n numbers - 1 to n
     */
    val n = 10
    val sumOfFirstNNumbers = (n * (n + 1)) / 2
}
