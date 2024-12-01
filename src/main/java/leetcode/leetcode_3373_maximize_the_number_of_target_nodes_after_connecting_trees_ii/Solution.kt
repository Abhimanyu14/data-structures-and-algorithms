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
    val result = IntArray(edges1.size + 1)
    fun createGraph(edges: Array<IntArray>): MutableMap<Int, MutableList<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach { (from, to) ->
            graph.computeIfAbsent(from) { mutableListOf() }.add(to)
            graph.computeIfAbsent(to) { mutableListOf() }.add(from)
        }
        return graph
    }

    val graph1 = createGraph(edges1)
    val graph2 = createGraph(edges2)
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
    val tree2Value = max(tree2Node1, edges2.size + 1 - tree2Node1)
    visited.clear()
    evenSet.clear()
    val tree1Node1 = bfs(graph1, 0, true)
    result[0] = tree1Node1 + tree2Value
    for (i in 1..<edges1.size + 1) {
        result[i] = if (evenSet.contains(i)) {
            tree1Node1 + tree2Value
        } else {
            edges1.size + 1 - tree1Node1 + tree2Value
        }
    }
    return result
}

private fun main() {

}
