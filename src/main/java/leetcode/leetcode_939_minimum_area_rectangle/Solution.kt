package leetcode.leetcode_939_minimum_area_rectangle

import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-area-rectangle/
 *
 * Data Structure - Set
 * Algorithm - Iteration & Maths
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 256 ms, faster than 50.00%
 * Memory Usage: 56 MB, less than 14.29%
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 */
private fun minAreaRect(points: Array<IntArray>): Int {
    var result = Int.MAX_VALUE
    val set = mutableSetOf<Pair<Int, Int>>()
    points.forEach { (x, y) ->
        set.add(Pair(x, y))
    }
    fun canBeDiagonal(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        return x1 != x2 && y1 != y2
    }
    fun area(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        return abs(x1 - x2) * abs(y1 - y2)
    }
    for (i in 0..<points.lastIndex) {
        for (j in (i + 1)..points.lastIndex) {
            if (canBeDiagonal(points[i][0], points[i][1], points[j][0], points[j][1])) {
                if (set.contains(Pair(points[i][0], points[j][1])) && set.contains(Pair(points[j][0], points[i][1]))) {
                    result = min(result, area(points[i][0], points[i][1], points[j][0], points[j][1]))
                }
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
