package data_structures_and_algorithms.graph

import java.util.PriorityQueue

/**
 * Graph: Node value : List<Pair(Next Node, Weight)>
 * Complexity - O((E + V) log V)
 */
private fun findShortestPath(graph: Map<Int, List<Pair<Int, Int>>>, n: Int, start: Int): IntArray {
    val cost = IntArray(n) { Int.MAX_VALUE }
    cost[start] = 0

    val visited = Array(n) { false }
    val prev = IntArray(n) { -1 }
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.second - b.second // Pair<index, cost>
    }
    priorityQueue.offer(Pair(start, 0))
    while (priorityQueue.isNotEmpty()) {
        val (currentValue, currentCost) = priorityQueue.poll()
        visited[currentValue] = true
        if (cost[currentValue] < currentCost) {
            continue
        }
        graph[currentValue]?.forEach { (nextValue, nextCost) ->
            if (!visited[nextValue]) {
                val updatedCost = cost[currentValue] + nextCost
                if (updatedCost < cost[nextValue]) {
                    prev[nextValue] = currentValue
                    cost[nextValue] = updatedCost
                    priorityQueue.offer(Pair(nextValue, updatedCost))
                }
            }
        }
    }
    return cost
}

fun main() {
    val graph = mapOf(
        0 to listOf(Pair(1, 4), Pair(2, 1)),
        1 to listOf(Pair(3, 1)),
        2 to listOf(Pair(1, 2), Pair(3, 5)),
        3 to listOf(Pair(4, 3)),
    )
    val result = findShortestPath(graph, 5, 0)
    println(result.joinToString(", "))
}
