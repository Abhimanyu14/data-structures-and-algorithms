package data_structures_and_algorithms.graph

/**
 * TODO(Abhi) - To complete
 *
 * Complexity - O(EV)
 * Use when Dijkstra fails, i.e. When graph has -ve weight
 */
private data class Edge(
    val from: Int,
    val to: Int,
    val weight: Int,
)

private fun shortestPath(
    edges: List<Edge>,
    n: Int, // Number of vertices
    start: Int,
): IntArray {
    val cost = IntArray(n) { Int.MAX_VALUE }
    cost[start] = 0

    repeat(n - 1) {
        edges.forEach {
            if (cost[it.from] != Int.MAX_VALUE && cost[it.from] + it.weight < cost[it.to]) {
                cost[it.to] = cost[it.from] + it.weight
            }
        }
    }

    edges.forEach {
        if (cost[it.from] == Int.MAX_VALUE) {
            if (cost[it.to] != Int.MAX_VALUE) {
                cost[it.to] = Int.MAX_VALUE
            }
        } else if (cost[it.from] != Int.MAX_VALUE && cost[it.from] + it.weight < cost[it.to]) {
            cost[it.to] = Int.MAX_VALUE
        }
    }
    return cost
}
