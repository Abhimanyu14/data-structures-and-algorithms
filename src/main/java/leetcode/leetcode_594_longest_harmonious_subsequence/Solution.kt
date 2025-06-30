package leetcode.leetcode_594_longest_harmonious_subsequence

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-harmonious-subsequence/description/?envType=daily-question&envId=2025-06-30
 *
 * Data Structure - [Map]
 * Algorithm - Counting
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
private fun findLHS(nums: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    for (num in nums) {
        counter[num] = counter.getOrDefault(num, 0) + 1
    }
    for ((key, value1) in counter) {
        counter[key + 1]?.let { value2 ->
            result = max(result, value1 + value2)
        }
    }
    return result
}

private fun main() {

}
