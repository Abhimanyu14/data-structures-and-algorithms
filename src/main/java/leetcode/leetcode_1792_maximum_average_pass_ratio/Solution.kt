package leetcode.leetcode_1792_maximum_average_pass_ratio

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/maximum-average-pass-ratio/?envType=daily-question&envId=2024-12-15
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heapify and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 277 ms, faster than 66.67%
 * Memory Usage: 89.9 MB, less than 100.00%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
    var result = 0.0
    val priorityQueue = PriorityQueue<Triple<Int, Int, Double>> { a, b ->
        b.third.compareTo(a.third)
    }
    for (c in classes) {
        priorityQueue.offer(Triple(c[0], c[1], ((c[0] + 1).toDouble() / (c[1] + 1)) - (((c[0]).toDouble() / (c[1])))))
    }
    for (i in 0..<extraStudents) {
        val current = priorityQueue.poll()
        priorityQueue.offer(
            Triple(
                current.first + 1,
                current.second + 1,
                ((current.first + 1 + 1).toDouble() / (current.second + 1 + 1)) -
                        (((current.first + 1).toDouble() / (current.second + 1)))
            )
        )
    }
    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        result += (current.first.toDouble() / current.second)
    }
    return (result / classes.size)
}

private fun main() {

}
