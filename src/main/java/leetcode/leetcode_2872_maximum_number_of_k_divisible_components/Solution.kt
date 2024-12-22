package leetcode.leetcode_2872_maximum_number_of_k_divisible_components

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-k-divisible-components/?envType=daily-question&envId=2024-12-21
 *
 * Data Structure - Graph
 * Algorithm - Graph Creation using Adjacency Matrix and DFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 204 ms, faster than 100.00%
 * Memory Usage: 83 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    var result = 0
    val graph = mutableMapOf<Int, MutableList<Int>>()
    for (edge in edges) {
        graph.computeIfAbsent(edge[0]) { mutableListOf() }.add(edge[1])
        graph.computeIfAbsent(edge[1]) { mutableListOf() }.add(edge[0])
    }
    val visited = mutableSetOf<Int>()
    fun dfs(current: Int): Long {
        visited.add(current)
        var sum = 0L
        graph[current]?.forEach {
            if (!visited.contains(it)) {
                sum += dfs(it)
            }
        }
        sum += values[current]
        if (sum % k == 0L) {
            result++
        }
        return sum
    }
    dfs(0)
    return result
}

private fun main() {

}
