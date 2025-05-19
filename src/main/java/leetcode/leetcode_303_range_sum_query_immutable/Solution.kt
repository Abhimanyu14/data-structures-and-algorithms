package leetcode.leetcode_303_range_sum_query_immutable

/**
 * leetcode - https://leetcode.com/problems/range-sum-query-immutable/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [IntArray]
 * Algorithm - Prefix Sum
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private class NumArray(nums: IntArray) {
    val prefixSum = IntArray(nums.size)

    init {
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            prefixSum[i] = sum
        }
    }

    /**
     * Time - O(1)
     */
    fun sumRange(left: Int, right: Int): Int {
        return if (left == 0) {
            prefixSum[right]
        } else {
            prefixSum[right] - prefixSum[left - 1]
        }
    }
}

private fun main() {

}
