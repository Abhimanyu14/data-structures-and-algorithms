package leetcode.leetcode_400_to_499.leetcode_452_minimum_number_of_arrows_to_burst_balloons

import java.util.PriorityQueue
import kotlin.math.sign

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * Using priority queue, greed, comparator
 * Source: https://www.youtube.com/watch?v=fvBhjAp0j9c
 *
 * Stats
 * Runtime: 873 ms, faster than 76.56%
 * Memory Usage: 86.3 MB, less than 91.41%
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
        while (priorityQueue.isNotEmpty() && priorityQueue.peek().first <= prev) {
            priorityQueue.poll()
        }
    }
    return result
}

private fun main() {

}
