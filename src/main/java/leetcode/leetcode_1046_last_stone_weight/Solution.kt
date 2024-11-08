package leetcode.leetcode_1046_last_stone_weight

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/last-stone-weight/
 *
 * Using priority queue
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 39 ms, faster than 14.58%
 * Memory Usage: 34.4 MB, less than 32.62%
 *
 * Time -
 * Space -
 */
private fun lastStoneWeight(stones: IntArray): Int {
    val priorityQueue = PriorityQueue { a: Int, b: Int ->
        b - a
    }
    stones.forEach {
        priorityQueue.offer(it)
    }
    while (priorityQueue.size > 1) {
        val x = priorityQueue.poll()
        val y = priorityQueue.poll()
        if (x > y) {
            priorityQueue.offer(x - y)
        }
    }
    return if (priorityQueue.isEmpty()) {
        0
    } else {
        priorityQueue.poll()
    }
}

private fun main() {

}
