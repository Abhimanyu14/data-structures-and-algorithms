package leetcode.leetcode_1009_complement_of_base_10_integer

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/complement-of-base-10-integer/submissions/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.5 MB, less than 100.00%
 *
 * Time - O(log(N))
 * Space - O(1)
 */
private fun bitwiseComplement(n: Int): Int {
    if (n == 0) {
        return 1
    }
    var result = 0
    var current = n
    var power = 0
    while (current != 0) {
        if (current % 2 == 0) {
            result += (2.0).pow(power).toInt()
        }
        current /= 2
        power++
    }
    return result
}

private fun main() {

}
