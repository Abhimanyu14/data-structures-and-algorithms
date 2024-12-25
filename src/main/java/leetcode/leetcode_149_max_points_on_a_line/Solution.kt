package leetcode.leetcode_149_max_points_on_a_line

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-points-on-a-line/
 *
 * Data Structure - Map
 * Algorithm - Maths - Slop
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 49 ms, faster than 21.62%
 * Memory Usage: 39.4 MB, less than 48.65%
 *
 * Time -
 * Space -
 */
private fun maxPoints(points: Array<IntArray>): Int {
    var result = 0
    fun getSlope(x1: Int, y1: Int, x2: Int, y2: Int): Double {
        if (x1 == x2) {
            return Double.MAX_VALUE
        }
        if (y1 == y2) {
            return 0.0
        }
        return (y2 - y1).toDouble() / (x2 - x1)
    }
    for (i in 0..<points.lastIndex) {
        val counter = mutableMapOf<Double, Int>()
        for (j in (i + 1)..points.lastIndex) {
            val slope = getSlope(points[i][0], points[i][1], points[j][0], points[j][1])
            counter[slope] = counter.getOrDefault(slope, 0) + 1
            result = max(result, counter.getOrDefault(slope, 0))
        }
    }
    return result + 1
}

private fun main() {

}
