package leetcode.leetcode_50_powx_n

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/powx-n/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Divide & Conquer (Recursion)
 *
 * Source - https://youtu.be/7pnhv842keE
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun myPow(x: Double, n: Int): Double {
    fun pow(x: Double, n: Int): Double {
        if (x == 0.0) {
            return 0.0
        }
        if (n == 0 || x == 1.0) {
            return 1.0
        }
        if (n == 1) {
            return x
        }
        val result = pow(x, n / 2)
        return if (n % 2 == 0) {
            result * result
        } else {
            result * result * x
        }
    }
    if (n < 0) {
        return 1.0 / pow(x, abs(n))
    }
    return pow(x, n)
}

/**
 * leetcode - https://leetcode.com/problems/powx-n/description/
 *
 * Data Structure - NA
 * Algorithm - Divide & Conquer (Recursion)
 *
 * Source - https://youtu.be/7pnhv842keE
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun myPowUsingRecursion(x: Double, n: Int): Double {
    if (n == 0) {
        return 1.0
    }
    if (n == 1) {
        return x
    }
    return if (n < 0) {
        1.0 / myPowUsingRecursion(x, n * -1)
    } else {
        if (n % 2 == 0) {
            myPowUsingRecursion(x, n / 2) * myPowUsingRecursion(x, n / 2)
        } else {
            myPowUsingRecursion(x, n / 2) * myPowUsingRecursion(x, (n + 1) / 2)
        }
    }
}

/**
 * leetcode - https://leetcode.com/problems/powx-n/description/
 *
 * Data Structure - NA
 * Algorithm - Naive - Repeated multiplication
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun myPowUsingBruteForce(x: Double, n: Int): Double {
    var result = 1.0
    for (i in 0..<abs(n)) {
        result *= x
    }
    if (n < 0) {
        return 1.0 / result
    }
    return result
}

private fun main() {

}
