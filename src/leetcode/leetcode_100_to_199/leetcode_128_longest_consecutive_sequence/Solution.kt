package leetcode.leetcode_100_to_199.leetcode_128_longest_consecutive_sequence

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Using set and map
 *
 * Stats
 * Runtime: 585 ms, faster than 47.17%
 * Memory Usage: 70.1 MB, less than 5.03%
 */
private fun longestConsecutive(nums: IntArray): Int {
    val set = nums.toSet()
    val visited = mutableSetOf<Int>()
    var result = 0
    var current = 0
    var pointer: Int
    nums.forEach {
        if (!visited.contains(it)) {
            current = 1
            visited.add(it)
            pointer = it
            while (set.contains(pointer - 1)) {
                pointer--
                current++
                visited.add(pointer)
            }
            pointer = it
            while (set.contains(pointer + 1)) {
                pointer++
                current++
                visited.add(pointer)
            }
            result = max(result, current)
        }
    }
    return result
}

private fun main() {

}
