package leetcode.leetcode_3203_find_minimum_diameter_after_merging_two_trees

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph
 * Algorithm - BFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
    fun createGraph(edges: Array<IntArray>): MutableMap<Int, MutableList<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach { (from, to) ->
            graph.computeIfAbsent(from) { mutableListOf() }.add(to)
            graph.computeIfAbsent(to) { mutableListOf() }.add(from)
        }
        return graph
    }

    val visited = mutableSetOf<Int>()
    fun getMaxDistance(graph: MutableMap<Int, MutableList<Int>>, currentNode: Int, currentDistance: Int): Int {
        visited.add(currentNode)
        var result = currentDistance
        graph[currentNode]?.forEach {
            if (!visited.contains(it)) {
                result = max(result, getMaxDistance(graph, it, currentDistance + 1))
            }
        }
        return result
    }

    fun getTreeMinAndMax(graph: MutableMap<Int, MutableList<Int>>, edges: Array<IntArray>): Pair<Int, Int> {
        visited.clear()
        var treeMin = getMaxDistance(graph, 0, 0)
        var treeMax = treeMin
        for (i in 1..edges.size) {
            visited.clear()
            val dist = getMaxDistance(graph, i, 0)
            treeMin = min(treeMin, dist)
            treeMax = max(treeMax, dist)
        }
        return Pair(treeMin, treeMax)
    }

    val graph1 = createGraph(edges1)
    val graph2 = createGraph(edges2)
    val (tree1Min, tree1Max) = getTreeMinAndMax(graph1, edges1)
    val (tree2Min, tree2Max) = getTreeMinAndMax(graph2, edges2)
    return maxOf(tree1Min + tree2Min + 1, tree1Max, tree2Max)
}

private fun main() {

}
