package leetcode.leetcode_3453_separate_squares_i

import kotlin.math.abs
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/separate-squares-i/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private const val delta = 1.0 / (100_000)
private fun separateSquares(squares: Array<IntArray>): Double {
    fun findTop(): Double {
        var top = 0.0
        for (i in squares.indices) {
            top = max(top, squares[i][1].toDouble() + squares[i][2])
        }
        return top
    }

    fun isBottomAreaGreaterThanOrEqualToTop(mid: Double): Boolean {
        var bottomArea = 0.0
        var topArea = 0.0
        for ((_, y, side) in squares) {
            if (y + side <= mid) {
                bottomArea += (side * side)
            } else if (y >= mid) {
                topArea += (side * side)
            } else {
                bottomArea += ((mid - y) * side)
                topArea += ((y + side - mid) * side)
            }
        }
        return bottomArea >= topArea
    }

    var bottom = 0.0
    var top = findTop()

    while (bottom < top && (abs(top - bottom) > delta)) {
        val mid = bottom + (top - bottom) / 2
        if (isBottomAreaGreaterThanOrEqualToTop(mid)) {
            top = mid
        } else {
            bottom = mid
        }
    }
    return bottom
}

private fun main() {

}
