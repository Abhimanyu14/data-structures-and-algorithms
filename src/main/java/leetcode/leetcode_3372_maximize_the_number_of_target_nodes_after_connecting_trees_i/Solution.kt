package leetcode.leetcode_3372_maximize_the_number_of_target_nodes_after_connecting_trees_i

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/
 *
 * Data Structure - Trees
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 567 ms, faster than 100.00%
 * Memory Usage: 63.5 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
    val n = edges1.size + 1
    val m = edges2.size + 1
    val result = IntArray(n)
    val graph1 = mutableMapOf<Int, MutableList<Int>>()
    val graph2 = mutableMapOf<Int, MutableList<Int>>()
    edges1.forEach { (from, to) ->
        graph1.computeIfAbsent(from) {
            mutableListOf()
        }.add(to)
        graph1.computeIfAbsent(to) {
            mutableListOf()
        }.add(from)
    }
    edges2.forEach { (from, to) ->
        graph2.computeIfAbsent(from) {
            mutableListOf()
        }.add(to)
        graph2.computeIfAbsent(to) {
            mutableListOf()
        }.add(from)
    }
    var tree2Max = Int.MIN_VALUE
    val visited = mutableSetOf<Int>()
    fun bfs(graph: MutableMap<Int, MutableList<Int>>, currentNode: Int, currentDistance: Int): Int {
        visited.add(currentNode)
        if (currentDistance == k) {
            return 1
        }
        var bfsResult = 1
        graph[currentNode]?.forEach {
            if (!visited.contains(it)) {
                bfsResult += bfs(graph, it, currentDistance + 1)
            }
        }
        return bfsResult
    }
    if (k >= 1) {
        repeat(m) {
            visited.clear()
            tree2Max = max(tree2Max, bfs(graph2, it, 1))
        }
    }
    repeat(n) {
        visited.clear()
        result[it] = bfs(graph1, it, 0) + max(tree2Max, 0)
    }
    return result
}

private fun main() {

}
