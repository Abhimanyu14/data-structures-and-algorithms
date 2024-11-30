package leetcode.leetcode_560_subarray_sum_equals_k

/**
 * leetcode - https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(1)
 */
private fun subarraySum(nums: IntArray, k: Int): Int {
    var result = 0
    var current: Int
    for (i in nums.indices) {
        current = 0
        for (j in i..nums.lastIndex) {
            current += nums[j]
            if (current == k) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
