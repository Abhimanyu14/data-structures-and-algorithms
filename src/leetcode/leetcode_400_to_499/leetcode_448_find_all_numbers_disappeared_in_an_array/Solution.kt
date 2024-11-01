package leetcode.leetcode_400_to_499.leetcode_448_find_all_numbers_disappeared_in_an_array

import kotlin.math.abs

/**
 * Input manipulation
 * Source - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/1084014/O(n)-%2B-O(1)
 *
 * Stats
 * Runtime: 604 ms, faster than 83.98%
 * Memory Usage: 70.9 MB, less than 72.93%
 */
private fun findDisappearedNumbers(nums: IntArray): List<Int> {
    nums.forEach {
        nums[abs(it) - 1] = -abs(nums[abs(it) - 1])
    }
    val result = mutableListOf<Int>()
    nums.forEachIndexed { index, num ->
        if (num > 0) {
            result.add(index + 1)
        }
    }
    return result
}

/**
 * Set operations
 *
 * Stats
 * Runtime: 1058 ms, faster than 24.31%
 * Memory Usage: 79 MB, less than 5.52%
 */
private fun findDisappearedNumbersUsingSet(nums: IntArray): List<Int> {
    return ((1..nums.size) - nums.toSet()).toList()
}

private fun main() {
    println(findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
    println(findDisappearedNumbers(intArrayOf(1, 1)))
}
