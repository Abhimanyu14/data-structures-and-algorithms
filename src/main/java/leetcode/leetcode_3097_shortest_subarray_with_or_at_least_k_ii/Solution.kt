package leetcode.leetcode_3097_shortest_subarray_with_or_at_least_k_ii

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/?envType=daily-question&envId=2024-11-10
 *
 * Using sliding window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 47 ms, faster than 100.00%
 * Memory Usage: 76.9 MB, less than 50.00%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
    if (k == 0) {
        return 1
    }
    var result = nums.size + 1
    val bits = IntArray(32)
    var left = 0
    var currentOrValue: Int
    for (right in nums.indices) {
        currentOrValue = 0
        repeat(32) {
            if (nums[right] and (1 shl it) != 0) {
                bits[it]++
            }
            if (bits[it] > 0) {
                currentOrValue = currentOrValue or (1 shl it)
            }
        }
        if (currentOrValue >= k) {
            result = min(result, right - left + 1)
        }
        while (currentOrValue >= k) {
            currentOrValue = 0
            repeat(32) {
                if (nums[left] and (1 shl it) != 0) {
                    bits[it]--
                }
                if (bits[it] > 0) {
                    currentOrValue = currentOrValue or (1 shl it)
                }
            }
            left++
            if (currentOrValue >= k) {
                result = min(result, right - left + 1)
            }
        }
    }
    return if (result == nums.size + 1) {
        -1
    } else {
        result
    }
}

private fun main() {

}
