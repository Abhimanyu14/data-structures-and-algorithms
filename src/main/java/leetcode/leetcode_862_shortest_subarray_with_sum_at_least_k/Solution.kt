package leetcode.leetcode_862_shortest_subarray_with_sum_at_least_k

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 3570 ms, faster than 5.19%
 * Memory Usage: 53.9 MB, less than 46.39%
 *
 * Time -
 * Space -
 */
private fun shortestSubarray(nums: IntArray, k: Int): Int {
    var result = Int.MAX_VALUE
    var currentSum = 0L
    for (i in 0..nums.lastIndex) {
        currentSum = 0
        if (nums[i] <= 0) {
            continue
        }
        for (j in i..nums.lastIndex) {
            currentSum += nums[j]
            if (currentSum >= k) {
                result = min(result, j - i + 1)
                break
            }
            if (currentSum <= 0) {
                break
            }
        }
    }
    return if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
}

private fun main() {

}
