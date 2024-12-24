package leetcode.leetcode_3203_find_minimum_diameter_after_merging_two_trees

import java.util.LinkedList
import java.util.Queue
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph
 * Algorithm - BFS and Topological Sort
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 128 ms, faster than 100.00%
 * Memory Usage: 109 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
    fun createGraph(edges: Array<IntArray>): Array<MutableList<Int>> {
        val graph: Array<MutableList<Int>> = Array(edges.size + 1) {
            mutableListOf()
        }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        return graph
    }

    fun findDiameter(graph: Array<MutableList<Int>>): Int {
        val degrees = IntArray(graph.size)
        val leavesQueue: Queue<Int> = LinkedList()

        // Initialize the degree of each node and add leaves (nodes with degree 1) to the queue
        for (node in graph.indices) {
            degrees[node] = graph[node].size
            if (degrees[node] == 1) {
                leavesQueue.offer(node)
            }
        }

        var remainingNodes = graph.size
        var leavesLayersRemoved = 0

        // Process the leaves until there are 2 or fewer nodes remaining
        while (remainingNodes > 2) {
            val size = leavesQueue.size
            remainingNodes -= size
            leavesLayersRemoved++

            // Remove the leaves from the queue and update the degrees of their neighbors
            for (i in 0..<size) {
                val currentNode = leavesQueue.poll()

                // Process the neighbors of the current leaf
                for (neighbor in graph[currentNode]) {
                    degrees[neighbor]--
                    if (degrees[neighbor] == 1) {
                        leavesQueue.offer(neighbor)
                    }
                }
            }
        }

        // If exactly two nodes remain, return the diameter as twice the number of layers of leaves removed + 1
        if (remainingNodes == 2) {
            return 2 * leavesLayersRemoved + 1
        }
        return 2 * leavesLayersRemoved
    }

    val graph1 = createGraph(edges1)
    val graph2 = createGraph(edges2)
    val diameter1 = findDiameter(graph1)
    val diameter2 = findDiameter(graph2)
    val combinedDiameter = ceil(diameter1 / 2.0).toInt() + ceil(diameter2 / 2.0).toInt() + 1
    return maxOf(diameter1, diameter2, combinedDiameter)
}

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
private fun minimumDiameterAfterMergeUsingBruteForce(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
    fun createGraph(edges: Array<IntArray>): Map<Int, List<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((from, to) in edges) {
            graph.computeIfAbsent(from) { mutableListOf() }.add(to)
            graph.computeIfAbsent(to) { mutableListOf() }.add(from)
        }
        return graph
    }

    fun getMaxDistanceFromNode(
        graph: Map<Int, List<Int>>,
        currentNode: Int,
        currentDistance: Int,
        visited: Set<Int>,
    ): Int {
        var result = currentDistance
        graph[currentNode]?.forEach { adjacentNode ->
            if (!visited.contains(adjacentNode)) {
                result = max(
                    result,
                    getMaxDistanceFromNode(graph, adjacentNode, currentDistance + 1, visited + currentNode),
                )
            }
        }
        return result
    }

    fun getTreeMinAndMax(graph: Map<Int, List<Int>>): Pair<Int, Int> {
        var treeMin = getMaxDistanceFromNode(graph, 0, 0, emptySet())
        var treeMax = treeMin
        for (i in 1..<graph.size) {
            val distance = getMaxDistanceFromNode(graph, i, 0, emptySet())
            treeMin = min(treeMin, distance)
            treeMax = max(treeMax, distance)
        }
        return Pair(treeMin, treeMax)
    }

    val graph1 = createGraph(edges1)
    val graph2 = createGraph(edges2)
    val (tree1Min, tree1Max) = getTreeMinAndMax(graph1)
    val (tree2Min, tree2Max) = getTreeMinAndMax(graph2)
    return maxOf(tree1Min + tree2Min + 1, tree1Max, tree2Max)
}

private fun main() {

}
