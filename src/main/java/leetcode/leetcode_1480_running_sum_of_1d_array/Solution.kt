package leetcode.leetcode_1480_running_sum_of_1d_array

/**
 * leetcode - https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 37.2 MB, less than 55.16%
 *
 * Time -
 * Space -
 */
private fun runningSum(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    result[0] = nums[0]
    for (i in 1..nums.lastIndex) {
        result[i] = nums[i] + result[i - 1]
    }
    return result
}

private fun main() {

}
