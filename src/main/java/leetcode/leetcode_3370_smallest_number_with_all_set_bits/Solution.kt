package leetcode.leetcode_3370_smallest_number_with_all_set_bits

import kotlin.math.floor
import kotlin.math.log2
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/smallest-number-with-all-set-bits/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3 ms, faster than 100.00%
 * Memory Usage: 35.2 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun smallestNumber(n: Int): Int {
    return 2.0.pow(floor(log2(n.toDouble()) + 1)).toInt() - 1
}

/**
 * leetcode - https://leetcode.com/problems/smallest-number-with-all-set-bits/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 34.7 MB, less than 100.00%
 *
 * Time -
 * Space - O(1)
 */
private fun smallestNumberUsingIteration(n: Int): Int {
    var length = 0
    var temp = n
    while (temp != 0) {
        temp /= 2
        length++
    }
    var result = 0
    repeat(length) {
        result = (result * 2) + 1
    }
    return result
}

private fun main() {

}
