package leetcode.leetcode_225_implement_stack_using_queues

/**
 * leetcode - https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Using one queue
 *
 * Stats
 * Runtime: 168 ms, faster than 92.31%
 * Memory Usage: 35.6 MB, less than 89.23%
 */
private class MyStack() {
    val queue = ArrayDeque<Int>()
    var top: Int = 0

    fun push(x: Int) {
        top = x
        queue.addLast(x)
    }

    fun pop(): Int {
        repeat(queue.size - 1) {
            push(queue.removeFirst())
        }
        return queue.removeFirst()
    }

    fun top(): Int {
        return top
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

private fun main() {

}
