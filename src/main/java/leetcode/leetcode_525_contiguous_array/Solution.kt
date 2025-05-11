package leetcode.leetcode_525_contiguous_array

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/contiguous-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 434 ms, faster than 35.48%
 * Memory Usage: 50.2 MB, less than 37.10%
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun findMaxLength(nums: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = -1
    var count = 0
    for (i in nums.indices) {
        if (nums[i] == 1) {
            count++
        } else {
            count--
        }
        if (map.containsKey(count)) {
            result = max(result, (i - map.getOrDefault(count, 0)))
        } else {
            map[count] = i
        }
    }
    return result
}

private fun main() {

}
