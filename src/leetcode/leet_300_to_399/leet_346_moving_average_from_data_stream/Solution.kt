package leetcode.leet_300_to_399.leet_346_moving_average_from_data_stream

import java.util.Queue
import java.util.LinkedList

/**
 * Using queue
 *
 * Stats
 * Runtime: 375 ms, faster than 95.06%
 * Memory Usage: 43.1 MB, less than 97.53%
 */
class MovingAverage(size: Int) {
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
