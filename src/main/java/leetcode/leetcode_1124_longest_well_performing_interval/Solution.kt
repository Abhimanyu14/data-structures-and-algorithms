package leetcode.leetcode_1124_longest_well_performing_interval

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-well-performing-interval/description/?envType=problem-list-v2&envId=monotonic-stack
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map], [IntArray]
 * Algorithm - Prefix Sum
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Apple
 */
private fun longestWPI(hours: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    var sum = 0
    for (i in 0..hours.lastIndex) {
        if (hours[i] > 8) {
            sum++
        } else {
            sum--
        }
        if (sum > 0) {
            result = i + 1
        } else {
            map[sum - 1]?.let {
                result = max(result, i - it)
            }
        }
        map.putIfAbsent(sum, i)
    }
    return result
}

private fun main() {

}
