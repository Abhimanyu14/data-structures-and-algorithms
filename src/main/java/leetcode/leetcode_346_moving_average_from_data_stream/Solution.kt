package leetcode.leetcode_346_moving_average_from_data_stream

import java.util.LinkedList
import java.util.Queue

/**
 * leetcode - https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Using Java Queue
 *
 * Stats
 * Runtime: 375 ms, faster than 95.06%
 * Memory Usage: 43.1 MB, less than 97.53%
 */
class MovingAverageUsingJavaQueue(size: Int) {
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

/**
 * leetcode - https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Using Queue - Array Deque
 *
 * Stats
 * Runtime: 761 ms, faster than 61.54%
 * Memory Usage: 77.3 MB, less than 71.79%
 */
class MovingAverage(size: Int) {
    private val window = size
    private var total = 0
    private val queue = ArrayDeque<Int>()

    fun next(`val`: Int): Double {
        if (queue.size < window) {
            total += `val`
        } else {
            total = total - queue.removeFirst() + `val`
        }
        queue.addLast(`val`)
        return total.toDouble() / queue.size
    }
}

private fun main() {

}
