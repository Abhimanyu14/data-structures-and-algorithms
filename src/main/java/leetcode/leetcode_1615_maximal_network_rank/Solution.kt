package leetcode.leetcode_1615_maximal_network_rank

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximal-network-rank/description/
 *
 * Data Structure - Graph
 * Algorithm - Graph degree counting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 18 ms, faster than 81.82%
 * Memory Usage: 52.01 MB, less than 81.82%
 *
 * E: Edges
 * V: Vertices
 *
 * Time - O(E + V^2)
 * Space - O(E)
 *
 * Companies - Apple, Google, Microsoft
 */
private fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
    var result = 0
    val graph = Array(n) {
        mutableSetOf<Int>()
    }
    for ((from, to) in roads) {
        graph[from].add(to)
        graph[to].add(from)
    }
    for (i in 0..<n) {
        for (j in (i + 1)..<n) {
            result = if (graph[i].contains(j)) {
                max(result, graph[i].size + graph[j].size - 1)
            } else {
                max(result, graph[i].size + graph[j].size)
            }
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
