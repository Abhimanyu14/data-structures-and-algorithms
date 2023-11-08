package leetcode.leet_1900_to_1999.leet_1921_eliminate_maximum_number_of_monsters

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 503 ms, faster than 100.00%
 * Memory Usage: 54.8 MB, less than 100.00%
 */
private fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
    val priorityQueue = PriorityQueue<Float>()
    for (i in dist.indices) {
        priorityQueue.offer(dist[i].toFloat() / speed[i].toFloat())
    }
    var time = 0F
    var result = 0
    while (priorityQueue.isNotEmpty()) {
        if (priorityQueue.poll() > time) {
            result++
        } else {
            return result
        }
        time++
    }
    return result
}

private fun main() {

}
