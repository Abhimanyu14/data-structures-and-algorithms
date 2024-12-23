package leetcode.leetcode_2360_longest_cycle_in_a_graph

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-cycle-in-a-graph/
 *
 * Data Structure - Graph, Array, and Map
 * Algorithm - Counting and DFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 73 ms, faster than 100.00%
 * Memory Usage: 58.4 MB, less than 100.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun longestCycle(edges: IntArray): Int {
    var result = -1
    val visited = BooleanArray(edges.size)
    for (i in edges.indices) {
        val map = mutableMapOf<Int, Int>()
        var time = 0
        var currentNode = i
        while (!visited[currentNode] && edges[currentNode] != -1 && !map.contains(edges[currentNode])) {
            map[currentNode] = time
            visited[currentNode] = true
            currentNode = edges[currentNode]
            time++
        }
        result = max(result, time + 1 - map.getOrDefault(edges[currentNode], time + 2))
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/longest-cycle-in-a-graph/
 *
 * Data Structure - Graph, Array and Map
 * Algorithm - DFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 */
private fun longestCycleUsingBruteForce(edges: IntArray): Int {
    var result = -1
    for (i in edges.indices) {
        val map = mutableMapOf<Int, Int>()
        var time = 0
        var currentNode = i
        while (edges[currentNode] != -1 && !map.contains(edges[currentNode])) {
            map[currentNode] = time
            currentNode = edges[currentNode]
            time++
        }
        result = max(result, time + 1 - map.getOrDefault(edges[currentNode], time + 2))
    }
    return result
}

private fun main() {

}
