package leetcode.leetcode_2461_maximum_sum_of_distinct_subarrays_with_length_k

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/?envType=daily-question&envId=2024-11-19
 *
 * Using sliding window
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    if (nums.size < k) {
        return 0
    }
    var result = 0L
    var current = 0L
    val counter = mutableMapOf<Int, Int>()
    var index = 0
    while (index < k) {
        current += nums[index]
        counter[nums[index]] = counter.getOrDefault(nums[index], 0) + 1
        index++
    }
    if (counter.size == k) {
        result = max(result, current)
    }
    while (index < nums.size) {
        counter[nums[index]] = counter.getOrDefault(nums[index], 0) + 1
        current += nums[index]
        if (counter.getOrDefault(nums[index - k], 0) == 1) {
            counter.remove(nums[index - k])
        } else {
            counter[nums[index - k]] = counter.getOrDefault(nums[index - k], 0) - 1
        }
        current -= nums[index - k]
        if (counter.size == k) {
            result = max(result, current)
        }
        index++
    }
    return result
}

private fun main() {

}
