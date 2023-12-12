package leetcode.leet_400_to_499.leet_452_minimum_number_of_arrows_to_burst_balloons

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * Using priority queue, greedy
 * Source: https://www.youtube.com/watch?v=fvBhjAp0j9c
 *
 * Stats
 * Runtime: 1103 ms, faster than 5.88%
 * Memory Usage: 86.6 MB, less than 88.23%
 */
private fun findMinArrowShots(points: Array<IntArray>): Int {
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        if (p1.second > p2.second) {
            1
        } else if (p1.second < p2.second) {
            -1
        } else {
            0
        }
    }
    points.forEach {
        priorityQueue.offer(Pair(it[0], it[1]))
    }
    var result = 0
    var prev: Int
    while (priorityQueue.isNotEmpty()) {
        result++
        prev = priorityQueue.poll().second
        println("$prev")
        while (priorityQueue.isNotEmpty() && priorityQueue.peek().first <= prev) {
            println("${priorityQueue.peek()}")
            priorityQueue.poll()
        }
    }
    return result
}

private fun main() {

}
