package leetcode.leetcode_3371_identify_the_largest_outlier_in_an_array

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/
 *
 * Data Structure - Map
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1281 ms, faster than 100.00%
 * Memory Usage: 73.2 MB, less than 100.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun getLargestOutlier(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    var sum = 0
    val map = mutableMapOf<Int, MutableList<Int>>()
    var temp : Int
    nums.forEachIndexed { index, num ->
        sum += num
        map.computeIfAbsent(num) {
            mutableListOf()
        }.add(index)
    }
    nums.forEachIndexed { index, num ->
        temp = sum - (num * 2)
        if (map.contains(temp)) {
            map.getOrDefault(temp, mutableListOf()).forEach {
                if (index != it) {
                    result = max(result, temp)
                }
            }
        }
    }
    return result
}

private fun main() {

}
