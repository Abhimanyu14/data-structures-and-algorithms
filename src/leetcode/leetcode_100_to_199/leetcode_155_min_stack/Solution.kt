package leetcode.leetcode_100_to_199.leetcode_155_min_stack

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/min-stack/
 *
 * Using Stack
 *
 * Stats
 * Runtime: 254 ms, faster than 18.60%
 * Memory Usage: 42.6 MB, less than 39.86%
 */
private class MinStack() {
    val stack = ArrayDeque<Pair<Int, Int>>()
    var currentMin = Int.MAX_VALUE

    fun push(`val`: Int) {
        stack.addLast(Pair(`val`, currentMin))
        currentMin = min(currentMin, `val`)
    }

    fun pop() {
        currentMin = stack.removeLast().second
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return currentMin
    }
}

private fun main() {

}
