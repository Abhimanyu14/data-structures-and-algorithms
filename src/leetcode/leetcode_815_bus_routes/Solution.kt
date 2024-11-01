package leetcode.leetcode_815_bus_routes

/**
 * leetcode - https://leetcode.com/problems/bus-routes/
 *
 * TODO(Abhi) - To revisit
 *
 * Using BFS
 *
 * Stats
 * Runtime: 426 ms, faster than 100.00%
 * Memory Usage: 53.7 MB, less than 100.00%
 */
private data class Node(
    val route: Set<Int>,
    val adjacentNodes: MutableList<Int> = mutableListOf(),
)

private fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    if (source == target) {
        return 0
    }
    fun doesRoutesHaveCommonStop(route1: IntArray, route2: IntArray): Boolean {
        var i = 0
        var j = 0
        while (i < route1.size && j < route2.size) {
            if (route1[i] == route2[j]) {
                return true
            }
            if (route1[i] < route2[j]) {
                i++
            } else {
                j++
            }
        }
        return false
    }

    for (i in routes.indices) {
        routes[i].sort()
    }

    // Iterate over each pair of routes and add an edge between them if there's a common stop.
    val graph: List<Node> = routes.map {
        Node(it.toSet())
    }
    for (i in graph.indices) {
        for (j in i + 1 until routes.size) {
            if (doesRoutesHaveCommonStop(routes[i], routes[j])) {
                graph[i].adjacentNodes.add(j)
                graph[j].adjacentNodes.add(i)
            }
        }
    }

    val queue = ArrayDeque<Int>()
    // Add all the routes in the queue that have the source as one of the stops.
    graph.forEachIndexed { index, node ->
        if (node.route.contains(source)) {
            queue.addLast(index)
        }
    }

    val visited: MutableSet<Int> = mutableSetOf()
    var busCount = 1
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val nodeIndex = queue.removeFirst()

            // Return busCount, if the stop target is present in the current route.
            if (graph[nodeIndex].route.contains(target)) {
                return busCount
            }

            // Add the adjacent routes.
            graph[nodeIndex].adjacentNodes.forEach { adj ->
                if (!visited.contains(adj)) {
                    visited.add(adj)
                    queue.add(adj)
                }
            }
        }
        busCount++
    }
    return -1
}

private fun main() {

}
