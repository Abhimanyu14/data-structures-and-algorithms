package leetcode.leetcode_724_find_pivot_index

/**
 * leetcode -
 *
 * Using prefix sum array
 *
 * Stats
 * Runtime: 283 ms, faster than 90.59%
 * Memory Usage: 40.8 MB, less than 90.59%
 */
/**
 * leetcode - https://leetcode.com/problems/find-pivot-index/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Prefix Sum
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun pivotIndex(nums: IntArray): Int {
    val sum = nums.sum()
    var leftSum = 0
    for (i in nums.indices) {
        if (leftSum == sum - nums[i] - leftSum) {
            return i
        }
        leftSum += nums[i]
    }
    return -1
}

private fun pivotIndexUsingArray(nums: IntArray): Int {
    val prefixSum = IntArray(nums.size + 2)
    prefixSum[1] = nums[0]
    for (i in 1..nums.lastIndex) {
        prefixSum[i + 1] = prefixSum[i - 1 + 1] + nums[i]
    }
    val total = prefixSum[nums.size]
    for (i in 1..<prefixSum.lastIndex) {
        if (prefixSum[i - 1] == total - prefixSum[i]) {
            return i - 1
        }
    }
    return -1
}

private fun main() {

}
