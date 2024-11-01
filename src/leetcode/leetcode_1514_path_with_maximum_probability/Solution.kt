package leetcode.leetcode_1514_path_with_maximum_probability

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/path-with-maximum-probability/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun maxProbability(
    n: Int,
    edges: Array<IntArray>,
    succProb: DoubleArray,
    start_node: Int,
    end_node: Int,
): Double {
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Double>>>()
    edges.forEachIndexed { index, it ->
        graph.computeIfAbsent(it[0]) {
            mutableListOf()
        }.add(Pair(it[1], succProb[index]))
        graph.computeIfAbsent(it[1]) {
            mutableListOf()
        }.add(Pair(it[0], succProb[index]))
    }

    var result = 0.0
    fun dfs (current: Int, visited: Set<Int>, prob: Double) {
        if (current == end_node) {
            result = max(result, prob)
            return
        }
        graph[current]?.forEach {
            if (!visited.contains(it.first)) {
                dfs(it.first, visited + it.first, prob * it.second)
            }
        }
    }
    dfs(start_node, setOf(start_node), 1.0)
    return result
}

private fun main() {

}
