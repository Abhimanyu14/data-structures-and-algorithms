package leetcode.leet_2600_to_2699.leet_2642_design_graph_with_shortest_path_calculator

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/design-graph-with-shortest-path-calculator/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Dijkstra algorithm
 *
 * Stats
 * Runtime: 885 ms, faster than 66.67%
 * Memory Usage: 69.9 MB, less than 100.00%
 */
private class Graph(n: Int, edges: Array<IntArray>) {
    val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }

    init {
        edges.forEach { (from, to, cost) ->
            graph[from].add(Pair(to, cost))
        }
    }

    fun addEdge(edge: IntArray) {
        graph[edge[0]].add(Pair(edge[1], edge[2]))
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        return findShortestPathCost(node1, node2)
    }

    fun findShortestPathCost(start: Int, end: Int): Int {
        val visited = Array(graph.size) { false }
        val cost = IntArray(graph.size) { Int.MAX_VALUE }
        val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
            a.second - b.second // Pair<index, cost>
        }
        cost[start] = 0
        priorityQueue.offer(Pair(start, 0))
        while (priorityQueue.isNotEmpty()) {
            val (currentValue, currentCost) = priorityQueue.poll()
            visited[currentValue] = true
            if (cost[currentValue] < currentCost) {
                continue
            }
            graph[currentValue].forEach { (nextValue, nextCost) ->
                if (!visited[nextValue]) {
                    val updatedCost = cost[currentValue] + nextCost
                    if (updatedCost < cost[nextValue]) {
                        cost[nextValue] = updatedCost
                        priorityQueue.offer(Pair(nextValue, updatedCost))
                    }
                }
            }
        }
        return if (cost[end] == Int.MAX_VALUE) {
            -1
        } else {
            cost[end]
        }
    }
}

private fun main() {

}
