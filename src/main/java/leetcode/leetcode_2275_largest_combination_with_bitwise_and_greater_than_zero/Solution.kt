package leetcode.leetcode_2275_largest_combination_with_bitwise_and_greater_than_zero

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/?envType=daily-question&envId=2024-11-07
 *
 * TODO(Abhi) - To revisit
 *
 * Using binary operations
 * [countLeadingZeroBits]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 62 ms, faster than 100.00%
 * Memory Usage: 57.7 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun largestCombination(candidates: IntArray): Int {
    fun numberOfBinaryDigits(n: Int): Int {
        if (n == 0) return 1  // Special case: 0 has 1 binary digit (just "0")
        return 32 - n.countLeadingZeroBits()
    }

    var size = 0
    candidates.forEach {
        size = max(size, numberOfBinaryDigits(it))
    }
    val bitCounter = IntArray(size)
    var i: Int
    var current: Int
    candidates.forEach {
        i = 0
        current = it
        while (current != 0) {
            if (current % 2 == 1) {
                bitCounter[i]++
            }
            current /= 2
            i++
        }
    }
    return bitCounter.max()
}

private fun main() {

}
