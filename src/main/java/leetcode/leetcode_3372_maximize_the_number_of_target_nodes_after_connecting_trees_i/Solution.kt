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
 *
 * Companies -
 */
private fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
    val result = IntArray(edges1.size + 1)
    val graph1 = Array(edges1.size + 1) {
        mutableListOf<Int>()
    }
    val graph2 = Array(edges2.size + 1) {
        mutableListOf<Int>()
    }
    for ((from, to) in edges1) {
        graph1[from].add(to)
        graph1[to].add(from)
    }
    for ((from, to) in edges2) {
        graph2[from].add(to)
        graph2[to].add(from)
    }

    var tree2Max = Int.MIN_VALUE
    val visited = mutableSetOf<Int>()
    fun bfs(graph: Array<MutableList<Int>>, currentNode: Int, currentDist: Int): Int {
        visited.add(currentNode)
        if (currentDist == k) {
            return 1
        }
        var bfsResult = 1
        graph[currentNode].forEach {
            if (!visited.contains(it)) {
                bfsResult += bfs(graph, it, currentDist + 1)
            }
        }
        return bfsResult
    }
    if (k >= 1) {
        repeat(edges2.size + 1) {
            visited.clear()
            tree2Max = max(tree2Max, bfs(graph2, it, 1))
        }
    }
    repeat(edges1.size + 1) {
        visited.clear()
        result[it] = bfs(graph1, it, 0) + max(tree2Max, 0)
    }
    return result
}

private fun main() {

}
