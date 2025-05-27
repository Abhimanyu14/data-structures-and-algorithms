package leetcode.leetcode_1857_largest_color_value_in_a_directed_graph

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph
 * Algorithm - DFS and Backtracking
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Google, Microsoft
 */
private class GraphNode(
    val color: Int,
    val neighbours: MutableList<Int> = mutableListOf(),
)

private fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val graph = Array(colors.length) {
        GraphNode(colors[it] - 'a')
    }
    for ((from, to) in edges) {
        if (from == to) {
            return -1
        }
        graph[from].neighbours.add(to)
    }
    var result = 0
    val visited = BooleanArray(colors.length)
    val inCurrentPath = BooleanArray(colors.length)
    val cache = Array(colors.length) {
        IntArray(26)
    }

    fun dfs(node: Int) {
        // Cycle detection
        if (inCurrentPath[node]) {
            result = -1
            return
        }
        if (visited[node]) {
            return
        }
        visited[node] = true
        inCurrentPath[node] = true
        for (neighbour in graph[node].neighbours) {
            dfs(neighbour)
            if (result == -1) {
                return
            }
            for (i in 0..25) {
                cache[node][i] = max(cache[node][i], cache[neighbour][i])
                result = max(result, cache[node][i])
            }
        }
        cache[node][graph[node].color]++
        result = max(result, cache[node][graph[node].color])
        inCurrentPath[node] = false
    }
    for (node in colors.indices) {
        if (!visited[node]) {
            dfs(node)
        }
        if (result == -1) {
            return -1
        }
    }
    return result
}

private fun main() {

}
