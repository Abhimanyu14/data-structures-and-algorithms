package leetcode.leetcode_442_find_all_duplicates_in_an_array

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * Using input data manipulation
 *
 * Stats
 * Runtime: 385 ms, faster than 100.00%
 * Memory Usage: 46 MB, less than 90.48%
 */
private fun findDuplicates(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[abs(nums[i]) - 1] < 0) {
            result.add(abs(nums[i]))
        } else {
            nums[abs(nums[i]) - 1] = -1 * nums[abs(nums[i]) - 1]
        }
    }
    return result
}

private fun main() {

}
