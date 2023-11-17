package leetcode.leet_1800_to_1899.leet_1877_minimize_maximum_pair_sum_in_array

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 *
 * Using sorting and two pointers - greedy
 *
 * Stats
 * Runtime: 1140 ms, faster than 21.43%
 * Memory Usage: 55.3 MB, less than 85.71%
 */
private fun minPairSum(nums: IntArray): Int {
    var result = 0
    val sorted = nums.sorted()
    for (i in 0 until (sorted.size / 2)) {
        result = max(result, sorted[i] + sorted[nums.lastIndex - i])
    }
    return result
}

private fun main() {

}
