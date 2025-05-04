package leetcode.leetcode_399_evaluate_division

/**
 * leetcode - https://leetcode.com/problems/evaluate-division/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph, [ArrayDeque] (Queue), [Set], [DoubleArray]
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * M: queries.size
 * N: equations.size
 * Time - O(M * N)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    val graph = mutableMapOf<String, MutableList<Pair<String, Double>>>()
    for (i in equations.indices) {
        graph.computeIfAbsent(equations[i][0]) {
            mutableListOf()
        }.add(Pair(equations[i][1], values[i]))
        graph.computeIfAbsent(equations[i][1]) {
            mutableListOf()
        }.add(Pair(equations[i][0], 1.0 / values[i]))
    }
    val result = DoubleArray(queries.size) { -1.0 }
    for (i in queries.indices) {
        if (!graph.contains(queries[i][0]) || !graph.contains(queries[i][1])) {
            result[i] = -1.0
            continue
        }
        if (queries[i][0] == queries[i][1]) {
            result[i] = 1.0
            continue
        }
        val visited = mutableSetOf<String>()
        val queue = ArrayDeque<Pair<String, Double>>()
        queue.addLast(Pair(queries[i][0], 1.0))
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (current.first == queries[i][1]) {
                result[i] = current.second
                break
            }
            if (visited.contains(current.first)) {
                continue
            }
            visited.add(current.first)
            graph[current.first]?.forEach {
                if (!visited.contains(it.first)) {
                    queue.addLast(Pair(it.first, it.second * current.second))
                }
            }
        }
    }
    return result
}

private fun main() {

}
