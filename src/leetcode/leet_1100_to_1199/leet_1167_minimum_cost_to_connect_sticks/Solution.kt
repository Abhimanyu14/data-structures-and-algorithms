package leetcode.leet_1100_to_1199.leet_1167_minimum_cost_to_connect_sticks

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 *
 * Using heap - implemented using priority queue
 *
 * Stats
 * Runtime: 360 ms, faster than 100.00%
 * Memory Usage: 38 MB, less than 100.00%
 */
private fun connectSticks(sticks: IntArray): Int {
    val priorityQueue = PriorityQueue<Int>()
    sticks.forEach {
        priorityQueue.offer(it)
    }
    var minCost = 0
    while (priorityQueue.size >= 2) {
        val first = priorityQueue.poll()
        val second = priorityQueue.poll()
        minCost += first + second
        priorityQueue.offer(first + second)
    }
    return minCost
}

private fun main() {
    println(connectSticks(intArrayOf(2, 4, 3)))
    println(connectSticks(intArrayOf(1, 8, 3, 5)))
    println(connectSticks(intArrayOf(5)))
}
