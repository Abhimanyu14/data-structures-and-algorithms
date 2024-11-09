package leetcode.leetcode_3300_minimum_element_after_replacement_with_digit_sum

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 36.7 MB, less than 83.91%
 *
 * Time -
 * Space -
 */
private fun minElement(nums: IntArray): Int {
    var result = Int.MAX_VALUE
    nums.forEach {
        var current = 0
        var temp = it
        while (temp != 0) {
            current += temp % 10
            temp /= 10
        }
        result = min(result, current)
    }
    return result
}

private fun main() {

}
