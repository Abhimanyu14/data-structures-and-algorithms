package leetcode.leetcode_155_min_stack

import java.util.Stack
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/min-stack/
 *
 * Using Stack
 *
 * Stats
 * Runtime: 52 ms, faster than 90.83%
 * Memory Usage: 40.9 MB, less than 68.88%
 */
private class MinStack {
    val stack = Stack<Pair<Int, Int>>()
    var currentMin = Int.MAX_VALUE

    fun push(`val`: Int) {
        stack.push(Pair(`val`, currentMin))
        currentMin = min(currentMin, `val`)
    }

    fun pop() {
        currentMin = stack.pop().second
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return currentMin
    }
}

private fun main() {

}
