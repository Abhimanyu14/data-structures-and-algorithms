package leetcode.leetcode_3373_maximize_the_number_of_target_nodes_after_connecting_trees_ii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/
 *
 * Data Structure - Graph, Map, List, Tree
 * Algorithm - BFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 390 ms, faster than 100.00%
 * Memory Usage: 267.4 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
    val n = edges1.size + 1
    val m = edges2.size + 1
    val result = IntArray(n)
    val graph1 = mutableMapOf<Int, MutableList<Int>>()
    val graph2 = mutableMapOf<Int, MutableList<Int>>()
    edges1.forEach { (from, to) ->
        graph1.computeIfAbsent(from) { mutableListOf() }.add(to)
        graph1.computeIfAbsent(to) { mutableListOf() }.add(from)
    }
    edges2.forEach { (from, to) ->
        graph2.computeIfAbsent(from) { mutableListOf() }.add(to)
        graph2.computeIfAbsent(to) { mutableListOf() }.add(from)
    }
    val visited = mutableSetOf<Int>()
    val evenSet = mutableSetOf<Int>()
    fun bfs(graph: MutableMap<Int, MutableList<Int>>, currentNode: Int, isEven: Boolean): Int {
        visited.add(currentNode)
        if (isEven) {
            evenSet.add(currentNode)
        }
        var bfsResult = if (isEven) {
            1
        } else {
            0
        }
        graph[currentNode]?.forEach {
            if (!visited.contains(it)) {
                bfsResult += bfs(graph, it, !isEven)
            }
        }
        return bfsResult
    }
    val tree2Node1 = bfs(graph2, 0, true)
    val tree2Value = max(tree2Node1, m - tree2Node1)
    visited.clear()
    evenSet.clear()
    val tree1Node1 = bfs(graph1, 0, true)
    result[0] = tree1Node1 + tree2Value
    for (i in 1..<n) {
        result[i] = if (evenSet.contains(i)) {
            tree1Node1 + tree2Value
        } else {
            n - tree1Node1 + tree2Value
        }
    }
    return result
}

private fun main() {

}
