package data_structures_and_algorithms.graph

import java.util.LinkedList

/**
 * Given - Graph has nodes from 0 to N-1
 */
private fun hasCycleUsingBfs(graph: MutableMap<Int, MutableList<Int>>): Boolean {
    val visited = BooleanArray(graph.size)
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(0, -1))
    while (queue.isNotEmpty()) {
        val (current, parent) = queue.pop()
        if (visited[current]) {
            return true
        }
        visited[current] = true
        graph[current]?.forEach {
            if (it != parent) {
                queue.offer(Pair(it, current))
            }
        }
    }
    return false
}
