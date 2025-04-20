package leetcode.leetcode_560_subarray_sum_equals_k

/**
 * leetcode - https://leetcode.com/problems/subarray-sum-equals-k/
 * https://leetcode.com/problems/subarray-sum-equals-k/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Map
 * Algorithm - Prefix Sum and Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 38 ms, faster than 64.67%
 * Memory Usage: 45.2 MB, less than 5.58%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun subarraySum(nums: IntArray, k: Int): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    var current = 0
    map[0] = 1
    nums.forEach {
        current += it
        map[current] = map.getOrDefault(current, 0) + 1
        result += map.getOrDefault(current - k, 0)
    }
    return result
}

private fun subarraySumUsingPrefixSumMap(nums: IntArray, k: Int): Int {
    var result = 0
    val prefixSumMap = mutableMapOf<Int, MutableList<Int>>()
    var currentSum = 0
    for (i in nums.indices) {
        currentSum += nums[i]
        prefixSumMap.computeIfAbsent(currentSum) {
            mutableListOf()
        }.add(i)
    }
    currentSum = 0
    for (i in nums.indices) {
        prefixSumMap.getOrDefault(k + currentSum, emptyList()).forEach {
            if (it >= i) {
                result++
            }
        }
        currentSum += nums[i]
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/subarray-sum-equals-k/
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
private fun subarraySumUsingBruteForce(nums: IntArray, k: Int): Int {
    var result = 0
    var sum: Int
    for (i in nums.indices) {
        sum = 0
        for (j in i..nums.lastIndex) {
            sum += nums[j]
            if (sum == k) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
