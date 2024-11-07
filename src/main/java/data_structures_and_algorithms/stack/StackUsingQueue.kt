package data_structures_and_algorithms.stack

import java.util.LinkedList
import java.util.Queue

class StackUsingQueue {
    private var queue: Queue<Int> = LinkedList()
    val size: Int
        get() = queue.size

    fun push(x: Int) {
        queue.offer(x)
        repeat(queue.size - 1) {
            queue.offer(queue.poll())
        }
    }

    fun pop(): Int? {
        return queue.poll()
    }

    fun peek(): Int? {
        return queue.peek()
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    fun clear() {
        queue.clear()
    }

    override fun toString(): String {
        val result = StringBuilder()
        result.append(']')
        if (size > 0) {
            result.insert(0, queue.peek())
            queue.offer(queue.poll())
        }
        repeat(queue.size - 1) {
            result.insert(0, "${queue.peek()}, ")
            queue.offer(queue.poll())
        }
        result.insert(0, '[')
        return result.toString()
    }
}
