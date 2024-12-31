package leetcode

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.log2
import kotlin.math.pow
import kotlin.math.sqrt

fun ascii() {
    val asciiCapitalA = 65
    val asciiSmallA = 97
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

fun binaryOperations() {
    /**
     * To get number of binary digits of a number
     */
    fun numberOfBinaryDigits(n: Int): Int {
        if (n == 0) return 1  // Special case: 0 has 1 binary digit (just "0")
        return 32 - n.countLeadingZeroBits()
    }

    /**
     * To count number of 1 bit in binary representation.
     */
    val value: Int = 123
    val bitsCount: Int = value.countOneBits()

    /**
     * To count leading zero bits
     */
    val leadingZeroBitCount: Int = value.countLeadingZeroBits()

    /**
     * To get if ith bit of a number is set
     */
    fun checkIthBitIsSet(n: Int, i: Int): Boolean {
        return (n and (1 shl i)) != 0
    }
}

fun maths() {
    /**
     * Sum of first n numbers - 1 to n
     */
    val n = 10
    val sumOfFirstNNumbers = (n * (n + 1)) / 2

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

    /**
     * Logarithm
     */
    val logBase10 = log10(100.0)
    val logBase2 = log2(100.0)

    /**
     * floor
     */
    val floorOfTenPointFive = floor(10.5)

    /**
     * Square Root
     */
    val squareRootOfSix = sqrt(6.0)

    /**
     * Check if a number is power of two
     */
    fun isPowerOfTwo(x: Int): Boolean {
        return (x != 0) && ((x and (x - 1)) == 0)
    }

    val is12PowerOfTwo = isPowerOfTwo(12)
    val is64PowerOfTwo = isPowerOfTwo(64)
    val is0PowerOfTwo = isPowerOfTwo(0)
}

fun arrayOperations() {
    /**
     * To clone an array
     */
    val array1 = intArrayOf(1, 2, 3)
    val cloneArray = array1.clone()

    /**
     * To swap two numbers
     */
    var a = 10
    var b = 20
    a = b.also {
        b = a
    }
}

fun stringOperations() {
    /**
     * Set<Char> from a String
     */
    val chars = "Temp".toSet()

    /**
     * To repeat a string n times
     */
    "0".repeat(4)
}

fun stringBuilderOperations() {
    /**
     * To insert at start of string builder
     */
    fun insertAtStart() {
        val stringBuilder = StringBuilder()
        stringBuilder.insert(0, 5)
    }

    /**
     * To reverse
     */
    fun reverse() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Test")
        stringBuilder.reverse()
    }
}

fun priorityQueueOperations() {
    /**
     * Priority queue decreasing order
     */
    fun priorityQueueDescendingOrder() {
        val pq = PriorityQueue { a: Int, b: Int ->
            b - a
        }
    }
}
