package leetcode.leet_1900_to_1999.leet_1944_number_of_visible_people_in_a_queue

import java.util.ArrayDeque

/**
 * leetcode - https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 *
 * TODO(Abhi) - To revisit
 *
 * Using monotonic stack
 *
 * Stats
 * Runtime: 593 ms, faster than 72.73%
 * Memory Usage: 59.5 MB, less than 9.09%
 */
private fun canSeePersonsCount(heights: IntArray): IntArray {
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
