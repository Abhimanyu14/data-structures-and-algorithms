package leetcode.leetcode_3243_shortest_distance_after_road_addition_queries_i

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/?envType=daily-question&envId=2024-11-27
 *
 * Data Structure - [Array], [IntArray], [ArrayDeque], [List], Graph
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 76 ms, faster than 100.00%
 * Memory Usage: 59 MB, less than 66.67%
 *
 * Q: queries.size
 * N: n
 * Time - O(Q * (N + Q))
 * Space - O(N + Q)
 *
 * Companies - Google, Microsoft
 */
private fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    val graph = Array(n) {
        if (it < n - 1) {
            mutableListOf(it + 1)
        } else {
            mutableListOf()
        }
    }
    val shortestDistance = IntArray(n) {
        it
    }

    fun addRoad(from: Int, to: Int) {
        graph[from].add(to)
        shortestDistance[to] = min(shortestDistance[to], shortestDistance[from] + 1)
        val queue = ArrayDeque<Int>()
        queue.add(to)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            graph[node].forEach {
                if (shortestDistance[it] > shortestDistance[node] + 1) {
                    shortestDistance[it] = shortestDistance[node] + 1
                    queue.addLast(it)
                }
            }
        }
    }
    for (i in queries.indices) {
        addRoad(queries[i][0], queries[i][1])
        result[i] = shortestDistance.last()
    }
    return result
}

private fun main() {

}
