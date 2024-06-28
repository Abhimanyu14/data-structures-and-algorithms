package leetcode.leet_2200_to_2299.leet_2285_maximum_total_importance_of_roads

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/maximum-total-importance-of-roads/
 *
 * Using counting and sorting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 594 ms, faster than 100.00%
 * Memory Usage: 76.2 MB, less than 55.56%
 *
 * Time -
 * Space -
 */
private fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
    var result = 0L
    val counter = LongArray(n)
    val priorityQueue = PriorityQueue<Long>()
    roads.forEach {
        counter[it[0]]++
        counter[it[1]]++
    }
    counter.forEach {
        priorityQueue.offer(it)
    }
    repeat(n) {
        result += (it + 1) * priorityQueue.poll()
    }
    return result
}


private fun main() {

}
