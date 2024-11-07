package leetcode.leetcode_232_implement_queue_using_stacks

/**
 * leetcode - https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Using two stacks - Amortized solution
 *
 * Stats
 * Runtime: 183 ms, faster than 75.56%
 * Memory Usage: 35.6 MB, less than 96.30%
 */
private class MyQueue() {
    val stack1 = ArrayDeque<Int>()
    val stack2 = ArrayDeque<Int>()
    var first: Int = 0

    fun push(x: Int) {
        if (stack1.isEmpty()) {
            first = x
        }
        stack1.addLast(x)
    }

    fun pop(): Int {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.addLast(stack1.removeLast())
            }
        }
        return stack2.removeLast()
    }

    fun peek(): Int {
        if (stack2.isNotEmpty()) {
            return stack2.last()
        }
        return first
    }

    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }
}

private fun main() {

}
