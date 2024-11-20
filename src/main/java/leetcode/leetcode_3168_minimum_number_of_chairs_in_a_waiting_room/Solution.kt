package leetcode.leetcode_3168_minimum_number_of_chairs_in_a_waiting_room

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 66.67%
 * Memory Usage: 35.4 MB, less than 14.29%
 *
 * Time -
 * Space -
 */
private fun minimumChairs(s: String): Int {
    var result = 0
    var current = 0
    s.forEach {
        if (it == 'E') {
            current++
            result = max(result, current)
        } else {
            current--
        }
    }
    return result
}

private fun main() {

}
