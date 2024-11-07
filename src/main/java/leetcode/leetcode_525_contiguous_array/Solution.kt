package leetcode.leetcode_525_contiguous_array

import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/contiguous-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Using map
 *
 * Stats
 * Runtime: 434 ms, faster than 35.48%
 * Memory Usage: 50.2 MB, less than 37.10%
 */
private fun findMaxLength(nums: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = -1
    var count = 0
    nums.forEachIndexed { index, num ->
        if (num == 1) {
            count++
        } else {
            count--
        }
        if (map.containsKey(count)) {
            result = max(result, (index - map.getOrDefault(count, 0)))
        } else {
            map[count] = index
        }
    }
    return result
}

private fun main() {

}
