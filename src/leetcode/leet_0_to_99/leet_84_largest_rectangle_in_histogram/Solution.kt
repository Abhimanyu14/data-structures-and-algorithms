package leetcode.leet_0_to_99.leet_84_largest_rectangle_in_histogram

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * TODO(Abhi) - To complete
 *
 * Using monotonic stack
 *
 * Stats
 */


/**
 * leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * TODO(Abhi) - To complete
 *
 * Using brute force
 *
 * Stats
 * Time Limit Exceeded
 */
private fun largestRectangleAreaBruteForce(heights: IntArray): Int {
    if (heights.size == 1) {
        return heights[0]
    }
    var currentMin: Int
    var result = heights.last()
    for (i in 0 until heights.lastIndex) {
        currentMin = heights[i]
        result = max(result, currentMin)
        for (j in i + 1 until heights.size) {
            currentMin = min(currentMin, heights[j])
            result = max(result, (j - i + 1) * currentMin)
        }
    }
    return result
}

private fun main() {

}
