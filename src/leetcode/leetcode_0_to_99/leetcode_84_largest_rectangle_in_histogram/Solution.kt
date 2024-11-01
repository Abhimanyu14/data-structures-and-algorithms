package leetcode.leetcode_0_to_99.leetcode_84_largest_rectangle_in_histogram

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * TODO(Abhi) - To revisit
 *
 * Using monotonic stack
 *
 * Stats
 * Runtime: 541 ms, faster than 26.40%
 * Memory Usage: 53.8 MB, less than 32.80%
 */
fun largestRectangleArea(heights: IntArray): Int {
    if (heights.size == 1) {
        return heights[0]
    }
    val stack = ArrayDeque<Pair<Int, Int>>()
    var maxArea = Int.MIN_VALUE
    var temp: Pair<Int, Int>
    var start: Int
    heights.forEachIndexed { index, height ->
        start = index
        while (stack.isNotEmpty() && height < stack.last().second) {
            temp = stack.removeLast()
            maxArea = max(maxArea, (index - temp.first) * temp.second)
            start = temp.first
        }
        stack.addLast(Pair(start, height))
    }
    while (stack.isNotEmpty()) {
        temp = stack.removeLast()
        maxArea = max(maxArea, (heights.size - temp.first) * temp.second)
    }
    return maxArea
}

/**
 * leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/
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
