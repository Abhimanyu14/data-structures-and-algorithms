package leetcode.leetcode_1900_to_1999.leetcode_1929_concatenation_of_array

/**
 * Initialization new array using init()
 *
 * Stats
 * Runtime: 422 ms, faster than 8.86%
 * Memory Usage: 49.2 MB, less than 8.86%
 */
fun getConcatenation(nums: IntArray) = IntArray(nums.size * 2) { nums[it % nums.size] }

/**
 * Spread operator
 *
 * Stats
 * Runtime: 376 ms, faster than 16.46%
 * Memory Usage: 47.2 MB, less than 18.99%
 */
fun getConcatenationUsingSpreadOperator(nums: IntArray) = intArrayOf(*nums, *nums)

/**
 * Traditional approach
 *
 * Stats
 * Runtime: 360 ms, faster than 18.35%
 * Memory Usage: 47 MB, less than 20.25%
 */
fun getConcatenationTraditionalApproach(nums: IntArray): IntArray {
    val result = IntArray(2 * nums.size)
    for (i in nums.indices) {
        result[i] = nums[i]
        result[nums.size + i] = nums[i]
    }
    return result
}

private fun main() {
    val input1 = intArrayOf(1, 2, 1)
    println(getConcatenationTraditionalApproach(input1).joinToString(", "))
}
