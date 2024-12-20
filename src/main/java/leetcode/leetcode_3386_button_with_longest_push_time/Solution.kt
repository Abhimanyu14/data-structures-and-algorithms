package leetcode.leetcode_3386_button_with_longest_push_time

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/button-with-longest-push-time/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 36.73%
 * Memory Usage: 44.9 MB, less than 28.57%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun buttonWithLongestTime(events: Array<IntArray>): Int {
    var result = events[0][0]
    var longestTime = events[0][1]
    for (i in 1..events.lastIndex) {
        if (events[i][1] - events[i - 1][1] > longestTime) {
            longestTime = events[i][1] - events[i - 1][1]
            result = events[i][0]
        } else if (events[i][1] - events[i - 1][1] == longestTime) {
            result = min(result, events[i][0])
        }
    }
    return result
}

private fun main() {

}
