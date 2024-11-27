package leetcode.leetcode_3243_shortest_distance_after_road_addition_queries_i

import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/?envType=daily-question&envId=2024-11-27
 *
 * Using Array, List, Map, Queue & LinkedList.
 *
 * [computeIfAbsent]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 76 ms, faster than 100.00%
 * Memory Usage: 59 MB, less than 66.67%
 *
 * Time -
 * Space -
 */
private fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    val roads = mutableMapOf<Int, MutableList<Int>>()
    val shortestDistance = IntArray(n)
    repeat(n) {
        shortestDistance[it] = it
    }
    for (i in 0..n - 2) {
        roads.computeIfAbsent(i) {
            mutableListOf()
        }.add(i + 1)
    }
    fun addRoad(from: Int, to: Int) {
        roads.computeIfAbsent(from) {
            mutableListOf()
        }.add(to)
        shortestDistance[to] = min(shortestDistance[to], shortestDistance[from] + 1)
        val toProcess: Queue<Int> = LinkedList()
        toProcess.add(to)
        while (toProcess.isNotEmpty()) {
            val current = toProcess.poll()
            roads[current]?.forEach {
                if (shortestDistance[it] > shortestDistance[current] + 1) {
                    shortestDistance[it] = shortestDistance[current] + 1
                    toProcess.add(it)
                }
            }
        }
    }
    queries.forEachIndexed { index, query ->
        addRoad(query[0], query[1])
        result[index] = shortestDistance[n - 1]
    }
    return result
}

private fun main() {

}
