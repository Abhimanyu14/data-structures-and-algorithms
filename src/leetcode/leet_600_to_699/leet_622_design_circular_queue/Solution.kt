package leetcode.leet_600_to_699.leet_622_design_circular_queue

/**
 * leetcode - https://leetcode.com/problems/design-circular-queue/
 *
 * Using naive solution
 *
 * Stats
 * Runtime: 217 ms, faster than 72.09%
 * Memory Usage: 41.8 MB, less than 34.88%
 */
private class MyCircularQueue(k: Int) {
    val queue = IntArray(k)
    var start = 0
    var size = 0

    fun enQueue(value: Int): Boolean {
        if (size == queue.size) {
            return false
        }
        size++
        queue[(start + size - 1) % queue.size] = value
        return true
    }

    fun deQueue(): Boolean {
        if (size == 0) {
            return false
        }
        size--
        start = (start + 1) % queue.size
        return true
    }

    fun Front(): Int {
        if (size == 0) {
            return -1
        }
        return queue[start]
    }

    fun Rear(): Int {
        if (size == 0) {
            return -1
        }
        return queue[(start + size - 1) % queue.size]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == queue.size
    }
}

/**
 * leetcode - https://leetcode.com/problems/design-circular-queue/
 *
 * Using naive solution
 *
 * Stats
 * Runtime: 246 ms, faster than 9.30%
 * Memory Usage: 42.7 MB, less than 30.23%
 */
private class MyCircularQueueWithStartAndEnd(k: Int) {
    val queue = IntArray(k)
    var start = 0
    var end = -1

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        if (isEmpty()) {
            end = start
        } else {
            end = (end + 1) % queue.size
        }
        queue[end] = value
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        if (start == end) {
            end = -1
        }
        start = (start + 1) % queue.size
        return true
    }

    fun Front(): Int {
        if (isEmpty()) {
            return -1
        }
        return queue[start]
    }

    fun Rear(): Int {
        if (isEmpty()) {
            return -1
        }
        return queue[end]
    }

    fun isEmpty(): Boolean {
        return end == -1
    }

    fun isFull(): Boolean {
        if (isEmpty()) {
            return false
        }
        return start == (end + 1) % queue.size
    }
}

private fun main() {

}
