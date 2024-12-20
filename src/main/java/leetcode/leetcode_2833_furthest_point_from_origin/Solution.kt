package leetcode.leetcode_2833_furthest_point_from_origin

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/furthest-point-from-origin/
 *
 * Data Structure - NA
 * Algorithm - Counting and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 80.00%
 * Memory Usage: 36.6 MB, less than 20.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun furthestDistanceFromOrigin(moves: String): Int {
    var lCount = 0
    var rCount = 0
    var underScoreCount = 0
    for (move in moves) {
        if (move == 'L') {
            lCount++
        } else if (move == 'R') {
            rCount++
        } else {
            underScoreCount++
        }
    }
    return max(lCount, rCount) - min(lCount, rCount) + underScoreCount
}

private fun main() {

}
