package leetcode.leetcode_1381_design_a_stack_with_increment_operation

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/design-a-stack-with-increment-operation/
 *
 * Using ArrayDeque
 *
 * Stats
 * Runtime: 297 ms, faster than 8.33%
 * Memory Usage: 50 MB, less than 8.33%
 */
private class CustomStack(maxSize: Int) {
    private val size = maxSize
    private val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        if (stack.size < size) {
            stack.addLast(x)
        }
    }

    fun pop(): Int {
        return if (stack.isEmpty()) {
            -1
        } else {
            stack.removeLast()
        }
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0..(min(k - 1, stack.lastIndex))) {
            stack[i] += `val`
        }
    }
}

private fun main() {

}
