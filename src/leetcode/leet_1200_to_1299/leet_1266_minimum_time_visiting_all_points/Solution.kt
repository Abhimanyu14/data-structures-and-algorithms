package leetcode.leet_1200_to_1299.leet_1266_minimum_time_visiting_all_points

import kotlin.math.abs
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-time-visiting-all-points/
 *
 * Using iteration, max and abs
 *
 * Stats
 * Runtime: 175 ms, faster than 22.22%
 * Memory Usage: 37.5 MB, less than 44.44%
 */
private fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var result = 0
    for (i in 1..points.lastIndex) {
        result += max(abs(points[i][0] - points[i - 1][0]), abs(points[i][1] - points[i - 1][1]))
    }
    return result
}

private fun main() {

}
