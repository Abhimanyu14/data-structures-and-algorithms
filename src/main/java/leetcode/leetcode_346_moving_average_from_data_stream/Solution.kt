package leetcode.leetcode_346_moving_average_from_data_stream

import java.util.LinkedList
import java.util.Queue

/**
 * leetcode - https://leetcode.com/problems/moving-average-from-data-stream/
 * Premium Question
 *
 * Data Structure - Queue - Array Deque
 * Algorithm - Queue addition and removal
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 761 ms, faster than 61.54%
 * Memory Usage: 77.3 MB, less than 71.79%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private class MovingAverage(private val size: Int) {
    val queue = ArrayDeque<Int>()
    var currentSum = 0.0

    fun next(`val`: Int): Double {
        queue.addLast(`val`)
        currentSum += `val`
        if (queue.size > size) {
            currentSum -= queue.removeFirst()
        }
        return currentSum / queue.size
    }
}

/**
 * leetcode - https://leetcode.com/problems/moving-average-from-data-stream/
 * Premium Question
 *
 * Data Structure - Queue - Java LinkedList
 * Algorithm - Queue addition and removal
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 375 ms, faster than 95.06%
 * Memory Usage: 43.1 MB, less than 97.53%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private class MovingAverageUsingJavaQueue(size: Int) {
    private val window = size
    private var total = 0
    private var count = 0
    private val queue: Queue<Int> = LinkedList()

    fun next(`val`: Int): Double {
        if (queue.size < window) {
            count++
            total += `val`
        } else {
            total = total - queue.poll() + `val`
        }
        queue.add(`val`)
        return total.toDouble() / count
    }
}

private fun main() {

}
