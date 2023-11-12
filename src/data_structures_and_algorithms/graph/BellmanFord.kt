package data_structures_and_algorithms.graph

/**
 * TODO(Abhi) - To complete
 *
 * Complexity - O(EV)
 * Use when Dijkstra fails, i.e. When graph has -ve weight
 */
private fun shortestPath(
    graph: Map<Int, List<Pair<Int, Int>>>,
    n: Int,
    start: Int,
) {
    val cost = IntArray(n) { Int.MAX_VALUE }
    cost[start] = 0

    repeat(n - 1){

    }
}
