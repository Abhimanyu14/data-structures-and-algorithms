package leetcode.leetcode_1245_tree_diameter

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/tree-diameter/description/?envType=problem-list-v2&envId=topological-sort
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta
 */
private fun treeDiameter(edges: Array<IntArray>): Int {
    val graph = Array(edges.size + 1) {
        mutableListOf<Int>()
    }
    for ((from, to) in edges) {
        graph[from].add(to)
        graph[to].add(from)
    }
    val visited = BooleanArray(edges.size + 1)
    fun dfs(current: Int): Pair<Int, Int> { // Diameter, Longest path
        visited[current] = true
        var longestDiameter = 0
        var longestPath = 0
        var secondLongestPath = 0
        graph[current].forEach {
            if (!visited[it]) {
                val (diameter, path) = dfs(it)
                longestDiameter = max(longestDiameter, diameter)
                if (path > longestPath) {
                    secondLongestPath = longestPath
                    longestPath = path
                } else if (path > secondLongestPath) {
                    secondLongestPath = path
                }
            }
        }
        return Pair(max(longestDiameter, longestPath + secondLongestPath + 1), max(longestPath, secondLongestPath) + 1)
    }
    return dfs(0).first - 1
}

private fun main() {

}
