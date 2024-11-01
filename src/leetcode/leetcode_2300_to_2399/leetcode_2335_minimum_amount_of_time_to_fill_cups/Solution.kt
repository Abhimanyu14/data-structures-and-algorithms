package leetcode.leetcode_2300_to_2399.leetcode_2335_minimum_amount_of_time_to_fill_cups

import java.util.PriorityQueue
import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 167 ms, faster than 9.09%
 * Memory Usage: 38.1 MB, less than 18.18%
 */
private fun fillCups(amount: IntArray): Int {
    val sorted = amount.sorted()
    if (sorted[0] + sorted[1] < sorted[2]) {
        return sorted[2]
    }
    return ceil(sorted.sum().toFloat() / 2).toInt()
}

/**
 * leetcode - https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 159 ms, faster than 18.18%
 * Memory Usage: 34.4 MB, less than 72.73%
 */
private fun fillCupsUsingPriorityQueue(amount: IntArray): Int {
    var result = 0
    val priorityQueue = PriorityQueue<Int> { a, b ->
        b - a
    }
    if (amount[0] != 0) {
        priorityQueue.offer(amount[0])
    }
    if (amount[1] != 0) {
        priorityQueue.offer(amount[1])
    }
    if (amount[2] != 0) {
        priorityQueue.offer(amount[2])
    }
    var x: Int
    var y: Int
    while (priorityQueue.size > 1) {
        x = priorityQueue.poll()
        y = priorityQueue.poll()
        result++
        priorityQueue.offer(x - 1)
        priorityQueue.offer(y - 1)
    }
    if (priorityQueue.size == 1) {
        result += priorityQueue.poll()
    }

    return result
}

private fun main() {
    println(fillCups(intArrayOf(5, 4, 4)))
}
