package leetcode.leetcode_868_binary_gap

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/binary-gap/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(log2(N))
 * Space - O(1)
 *
 * Companies - Google
 */
private fun binaryGap(n: Int): Int {
    var result = 0
    var temp = n
    var current = 0
    while (temp != 0) {
        if (temp % 2 == 1) {
            result = max(current, result)
            current = 1
        } else if (current > 0) {
            current++
        }
        temp /= 2
    }
    return result
}

private fun main() {

}
