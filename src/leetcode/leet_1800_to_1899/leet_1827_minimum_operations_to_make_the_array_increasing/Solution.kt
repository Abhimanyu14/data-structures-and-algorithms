package leetcode.leet_1800_to_1899.leet_1827_minimum_operations_to_make_the_array_increasing

/**
 * leetcode - https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 *
 * Using iteration and counting
 *
 * Stats
 * Runtime: 244 ms, faster than 18.18%
 * Memory Usage: 39.9 MB, less than 18.18%
 */
private fun minOperations(nums: IntArray): Int {
    var prev = nums[0]
    var result = 0
    for (i in 1..nums.lastIndex) {
        if (nums[i] >= prev + 1) {
            prev = nums[i]
        } else {
            result += prev + 1 - nums[i]
            prev++
        }
    }
    return result
}

private fun main() {

}
