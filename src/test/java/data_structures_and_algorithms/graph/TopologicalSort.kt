package data_structures_and_algorithms.graph

internal fun topologicalSort(graph: List<List<Int>>): IntArray {
    val result = IntArray(graph.size)
    var insertIndex = 0
    val stack = ArrayDeque<Int>()
    val visited = BooleanArray(graph.size)

    fun dfs(current: Int) {
        visited[current] = true
        for (adjacent in graph[current]) {
            if (!visited[adjacent]) {
                dfs(adjacent)
            }
        }
        stack.addLast(current)
    }

    for (i in graph.indices) {
        if (!visited[i]) {
            dfs(i)
        }
    }

    while (stack.isNotEmpty()) {
        result[insertIndex] = stack.removeLast()
        insertIndex++
    }
    return result
}
