package leetcode.leetcode_3065_minimum_operations_to_exceed_threshold_value_i

/**
 * leetcode - https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/
 *
 * Data Structure - NA
 * Algorithm - [count]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 55.56%
 * Memory Usage: 37.7 MB, less than 72.22%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun minOperations(nums: IntArray, k: Int): Int {
    return nums.count { it < k }
}

private fun main() {

}
