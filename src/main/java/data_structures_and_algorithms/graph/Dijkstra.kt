package data_structures_and_algorithms.graph

import java.util.PriorityQueue

/**
 * Graph: Node value : List<Pair(Next Node, Weight)>
 * Complexity - O((E + V) log V)
 */
private fun findMinimumCost(graph: Map<Int, List<Pair<Int, Int>>>, n: Int, start: Int): IntArray {
    val minimumCost = IntArray(n) { Int.MAX_VALUE }
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.second - b.second // Pair<index, cost> - Sort by cost
    }
    val visitedNodes = BooleanArray(n)
    minimumCost[start] = 0
    priorityQueue.offer(Pair(start, 0))

    while (priorityQueue.isNotEmpty()) {
        val (currentNode, currentCost) = priorityQueue.poll()
        visitedNodes[currentNode] = true
        if (minimumCost[currentNode] < currentCost) {
            continue
        }
        graph[currentNode]?.forEach { (nextNode, nextCost) ->
            if (!visitedNodes[nextNode]) {
                val updatedCost = minimumCost[currentNode] + nextCost
                if (updatedCost < minimumCost[nextNode]) {
                    minimumCost[nextNode] = updatedCost
                    priorityQueue.offer(Pair(nextNode, updatedCost))
                }
            }
        }
    }
    return minimumCost
}

fun main() {
    val graph1 = mapOf(
        0 to listOf(Pair(1, 4), Pair(2, 1)),
        1 to listOf(Pair(3, 1)),
        2 to listOf(Pair(1, 2), Pair(3, 5)),
        3 to listOf(Pair(4, 3)),
    )
    val result1 = findMinimumCost(graph1, 5, 0)
    println(result1.joinToString(", "))
    val graph2 = mapOf(
        0 to listOf(Pair(1, 4), Pair(2, 4)),
        1 to listOf(Pair(0, 4), Pair(2, 2)),
        2 to listOf(Pair(0, 4), Pair(1, 2), Pair(3, 3), Pair(4, 1)),
        3 to listOf(Pair(2, 3), Pair(5, 2)),
        4 to listOf(Pair(2, 1), Pair(5, 3)),
        5 to listOf(Pair(2, 6), Pair(3, 2), Pair(4, 3)),
    )
    val result2 = findMinimumCost(graph2, 6, 0)
    println(result2.joinToString(", "))
}
