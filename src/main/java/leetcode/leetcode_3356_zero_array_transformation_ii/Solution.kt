package leetcode.leetcode_3356_zero_array_transformation_ii

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Array] and Two Pointers
 * Algorithm - Binary Search and PrefixSum
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 47 ms, faster than 44.12%
 * Memory Usage: 129.3 MB, less than 52.94%
 *
 * Time - O(log (Q) * (Q + N))
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta
 */
private fun minZeroArrayUsingBinarySearch(nums: IntArray, queries: Array<IntArray>): Int {
    fun isZeroArray(k: Int): Boolean {
        val prefixSum = IntArray(nums.size + 1)
        for (i in 0..k) {
            prefixSum[queries[i][0]] += queries[i][2]
            prefixSum[queries[i][1] + 1] -= queries[i][2]
        }
        for (i in 1..prefixSum.lastIndex) {
            prefixSum[i] += prefixSum[i - 1]
        }
        for (i in nums.indices) {
            if (nums[i] > prefixSum[i]) {
                return false
            }
        }
        return true
    }

    var left = -1
    var right = queries.size
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (isZeroArray(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return if (left == queries.size) {
        -1
    } else {
        left + 1
    }
}

private fun main() {

}
