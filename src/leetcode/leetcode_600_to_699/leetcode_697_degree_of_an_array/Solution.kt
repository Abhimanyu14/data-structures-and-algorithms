package leetcode.leetcode_600_to_699.leetcode_697_degree_of_an_array

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/degree-of-an-array/
 *
 * Using class and iteration
 *
 * Stats
 * Runtime: 277 ms, faster than 57.50%
 * Memory Usage: 39.5 MB, less than 95.00%
 */
private class Num(
    var value: Int,
    var firstIndex: Int = -1,
    var lastIndex: Int = -1,
    var count: Int = -1,
)

private fun findShortestSubArray(nums: IntArray): Int {
    val map = mutableMapOf<Int, Num>()
    nums.forEachIndexed { index, num ->
        if (map.contains(num)) {
            map[num] = map[num]!!.apply {
                this.lastIndex = index
                this.count++
            }
        } else {
            map[num] = Num(num, index, index, 1)
        }
    }
    var max = 0
    var result = 0
    map.forEach { (key, value) ->
        if (value.count > max) {
            max = value.count
            result = value.lastIndex - value.firstIndex + 1
        } else if (value.count == max) {
            result = min(result, value.lastIndex - value.firstIndex + 1)
        }
    }
    return result
}

private fun main() {

}
