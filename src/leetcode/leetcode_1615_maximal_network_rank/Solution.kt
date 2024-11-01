package leetcode.leetcode_1615_maximal_network_rank

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximal-network-rank/
 *
 * Using graph
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 302 ms, faster than 75.00%
 * Memory Usage: 41.9 MB, less than 95.00%
 *
 * Time - O(N)
 * Space -
 */
private fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
    var result = 0
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    roads.forEach { (x: Int, y: Int) ->
        graph.computeIfAbsent(x) {
            mutableSetOf()
        }.add(y)
        graph.computeIfAbsent(y) {
            mutableSetOf()
        }.add(x)
    }

    fun findNetworkRank(i: Int, j: Int) {
        var current = 0
        current += if (graph[i].orEmpty().contains(j)) {
            (graph[i]?.size ?: 0) - 1
        } else {
            graph[i]?.size ?: 0
        }
        current += graph[j]?.size ?: 0
        result = max(result, current)
    }

    for (i in 0..n) {
        for (j in (i + 1)..n) {
            findNetworkRank(i, j)
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximal-network-rank/
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 736 ms, faster than 10.00%
 * Memory Usage: 52.5 MB, less than 60.00%
 *
 * Time -
 * Space -
 */
private fun maximalNetworkRankBruteForce(n: Int, roads: Array<IntArray>): Int {
    var result = 0
    fun findNetworkRank(i: Int, j: Int) {
        var current = 0
        roads.forEach { (x: Int, y: Int) ->
            if (x == i || x == j || y == i || y == j) {
                current++
            }
        }
        result = max(result, current)
    }

    for (i in 0..n) {
        for (j in (i + 1)..n) {
            findNetworkRank(i, j)
        }
    }
    return result
}

private fun main() {

}
