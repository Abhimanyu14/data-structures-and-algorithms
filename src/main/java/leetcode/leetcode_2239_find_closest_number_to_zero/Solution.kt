package leetcode.leetcode_2239_find_closest_number_to_zero

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/find-closest-number-to-zero/
 *
 * Using loop
 *
 * Stats
 * Runtime: 291 ms, faster than 94.12%
 * Memory Usage: 38.8 MB, less than 94.12%
 */
private fun findClosestNumber(nums: IntArray): Int {
    var result = nums[0]
    for (i in 1..nums.lastIndex) {
        if (abs(result) > abs(nums[i]) || (abs(result) == abs(nums[i]) && nums[i] > result)) {
            result = nums[i]
        }
    }
    return result
}

private fun main() {

}
