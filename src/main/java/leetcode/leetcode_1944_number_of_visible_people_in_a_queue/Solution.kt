package leetcode.leetcode_1944_number_of_visible_people_in_a_queue

import java.util.ArrayDeque

/**
 * leetcode - https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Decreasing Monotonic Stack
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun canSeePersonsCount(heights: IntArray): IntArray {
    val result = IntArray(heights.size)
    val stack = ArrayDeque<Int>()
    stack.addLast(heights.last())
    for (i in heights.lastIndex - 1 downTo 0) {
        while (stack.isNotEmpty() && stack.last() < heights[i]) {
            result[i]++
            stack.removeLast()
        }
        if (stack.isNotEmpty()) {
            result[i]++
        }
        stack.addLast(heights[i])
    }
    return result
}

private fun canSeePersonsCountLeftToRight(heights: IntArray): IntArray {
    val result = IntArray(heights.size)
    val stack = ArrayDeque<Int>()
    for (i in heights.indices) {
        while (stack.isNotEmpty() && heights[stack.last()] <= heights[i]) {
            result[stack.removeLast()] += 1
        }
        if (stack.isNotEmpty()) {
            result[stack.last()] += 1
        }
        stack.addLast(i)
    }
    return result
}

private fun main() {

}
