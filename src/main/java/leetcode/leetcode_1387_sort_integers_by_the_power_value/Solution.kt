package leetcode.leetcode_1387_sort_integers_by_the_power_value

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/sort-integers-by-the-power-value/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heapify and Maths
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 60 ms, faster than 90.00%
 * Memory Usage: 38.3 MB, less than 90.00%
 *
 * Time -
 * Space -
 */
private fun getKth(lo: Int, hi: Int, k: Int): Int {
    fun getPower(x: Int): Int {
        var power = 0
        var current = x
        while (current != 1) {
            if (current % 2 == 0) {
                current /= 2
            } else {
                current = (current * 3) + 1
            }
            power++
        }
        return power
    }
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.second == b.second) {
            a.first - b.first
        } else {
            a.second - b.second
        }
    }
    for (i in lo..hi) {
        priorityQueue.offer(Pair(i, getPower(i)))
    }
    repeat(k - 1) {
        priorityQueue.poll()
    }
    return priorityQueue.peek().first
}

private fun main() {

}
