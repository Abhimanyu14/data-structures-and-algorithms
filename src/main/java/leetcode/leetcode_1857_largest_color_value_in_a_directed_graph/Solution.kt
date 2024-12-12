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
 */
private class GraphNode(
    val color: Char,
    val adjacent: MutableList<Int> = mutableListOf(),
)

private fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    var result = 0
    val startingNodes = (colors.indices.toMutableSet())
    val graph = Array(colors.length) {
        GraphNode(colors[it])
    }
    edges.forEach { (from, to) ->
        graph[from].adjacent.add(to)
        startingNodes.remove(to)
    }

    if (startingNodes.isEmpty()) {
        return -1
    }

    val visited = IntArray(colors.length)
    val pathVisited = IntArray(colors.length)
    val colorCounter = IntArray(26)

    fun dfs(node: Int): Boolean {
        visited[node]++
        pathVisited[node]++
        colorCounter[graph[node].color - 'a']++
        result = max(result, colorCounter[graph[node].color - 'a'])
        for (adjacentNode in graph[node].adjacent) {
            if (pathVisited[node] == 1 || !dfs(adjacentNode)) {
                return false
            }
        }
        pathVisited[node]--
        colorCounter[graph[node].color - 'a']--
        return true
    }
    for (node in startingNodes) {
        if (visited[node] == 0 && !dfs(node)) {
            return -1
        }
    }
    return result
}

private fun main() {

}
