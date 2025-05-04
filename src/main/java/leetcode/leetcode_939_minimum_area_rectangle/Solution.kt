package leetcode.leetcode_939_minimum_area_rectangle

import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-area-rectangle/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set]
 * Algorithm - Iteration & Maths
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Microsoft
 */
private fun minAreaRect(points: Array<IntArray>): Int {
    var result = Int.MAX_VALUE
    val pointSet = points.map { it[0] to it[1] }.toSet()
    for (i in points.indices) {
        val (x1, y1) = points[i]
        for (j in (i + 1)..<points.size) {
            val (x2, y2) = points[j]
            if (x1 != x2 && y1 != y2 && (x1 to y2) in pointSet && (x2 to y1) in pointSet) {
                result = min(result, abs(x1 - x2) * abs(y1 - y2))
            }
        }
    }
    return if (result == Int.MAX_VALUE) {
        0
    } else {
        result
    }
}

private fun main() {

}
