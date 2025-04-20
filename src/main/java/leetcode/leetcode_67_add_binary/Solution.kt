package leetcode.leetcode_67_add_binary

import java.math.BigInteger

/**
 * leetcode - https://leetcode.com/problems/add-binary/
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(m + n)
 * Space - O(m + n)
 *
 * Companies - Meta
 */
private fun addBinary(a: String, b: String): String? {
    var x = BigInteger(a, 2)
    var y = BigInteger(b, 2)
    val zero = BigInteger("0", 2)
    var carry: BigInteger
    var answer: BigInteger
    while (y.compareTo(zero) != 0) {
        answer = x.xor(y)
        carry = x.and(y).shiftLeft(1)
        x = answer
        y = carry
    }
    return x.toString(2)
}

private fun addBinaryUsingIteration(a: String, b: String): String {
    val result = StringBuilder()
    var carry = 0
    var index1 = a.lastIndex
    var index2 = b.lastIndex
    fun addNextDigit(sum: Int) {
        when (sum) {
            0 -> {
                result.insert(0, '0')
                carry = 0
            }

            1 -> {
                result.insert(0, '1')
                carry = 0
            }

            2 -> {
                result.insert(0, '0')
                carry = 1
            }

            3 -> {
                result.insert(0, '1')
                carry = 1
            }
        }
    }
    while (index1 >= 0 && index2 >= 0) {
        addNextDigit(a[index1].digitToInt() + b[index2].digitToInt() + carry)
        index1--
        index2--
    }
    while (index1 >= 0) {
        addNextDigit(a[index1].digitToInt() + carry)
        index1--
    }
    while (index2 >= 0) {
        addNextDigit(b[index2].digitToInt() + carry)
        index2--
    }
    if (carry != 0) {
        addNextDigit(carry)
    }
    return result.toString()
}

private fun addBinary1(a: String, b: String): String {
    val result = StringBuilder()
    var aPointer = a.lastIndex
    var bPointer = b.lastIndex
    var carry = 0
    while (aPointer >= 0 && bPointer >= 0) {
        when (a[aPointer].digitToInt() + b[bPointer].digitToInt() + carry) {
            0 -> {
                result.append('0')
                carry = 0
            }

            1 -> {
                result.append('1')
                carry = 0
            }

            2 -> {
                result.append('0')
                carry = 1
            }

            else -> {
                result.append('1')
                carry = 1
            }
        }
        aPointer--
        bPointer--
    }
    while (aPointer >= 0) {
        when (a[aPointer].digitToInt() + carry) {
            0 -> {
                result.append('0')
                carry = 0
            }

            1 -> {
                result.append('1')
                carry = 0
            }

            2 -> {
                result.append('0')
                carry = 1
            }
        }
        aPointer--
    }
    while (bPointer >= 0) {
        when (b[bPointer].digitToInt() + carry) {
            0 -> {
                result.append('0')
                carry = 0
            }

            1 -> {
                result.append('1')
                carry = 0
            }

            2 -> {
                result.append('0')
                carry = 1
            }
        }
        bPointer--
    }
    if (carry == 1) {
        result.append('1')
    }
    return result.reverse().toString()
}

private fun main() {

}
