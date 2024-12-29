package leetcode.leetcode_1929_concatenation_of_array

/**
 * leetcode - https://leetcode.com/problems/concatenation-of-array/
 *
 * Data Structure - Array
 * Algorithm - Initialization new array using init()
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 422 ms, faster than 8.86%
 * Memory Usage: 49.2 MB, less than 8.86%
 *
 * Time -
 * Space -
 */
private fun getConcatenation(nums: IntArray): IntArray {
    return IntArray(nums.size * 2) { nums[it % nums.size] }
}

/**
 * leetcode - https://leetcode.com/problems/concatenation-of-array/
 *
 * Data Structure - Array
 * Algorithm - Spread operator
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 376 ms, faster than 16.46%
 * Memory Usage: 47.2 MB, less than 18.99%
 *
 * Time -
 * Space -
 */
private fun getConcatenationUsingSpreadOperator(nums: IntArray): IntArray {
    return intArrayOf(*nums, *nums)
}

/**
 * leetcode - https://leetcode.com/problems/concatenation-of-array/
 *
 * Data Structure - Array
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 360 ms, faster than 18.35%
 * Memory Usage: 47 MB, less than 20.25%
 *
 * Time -
 * Space -
 */
private fun getConcatenationUsingIteration(nums: IntArray): IntArray {
    val result = IntArray(2 * nums.size)
    for (i in nums.indices) {
        result[i] = nums[i]
        result[nums.size + i] = nums[i]
    }
    return result
}

private fun main() {
}
