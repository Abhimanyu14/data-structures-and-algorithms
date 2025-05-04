package leetcode.leetcode_1971_find_if_path_exists_in_graph

/**
 * leetcode -  https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph, [ArrayDeque] (Queue), [List], [Array]
 * Algorithm - BFS
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    if (source == destination) {
        return true
    }
    val graph = List(n) { mutableListOf<Int>() }
    for ((from, to) in edges) {
        graph[from].add(to)
        graph[to].add(from)
    }
    val queue = ArrayDeque<Int>()
    val visited = BooleanArray(n)
    queue.add(source)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (visited[current]) {
            continue
        }
        visited[current] = true
        graph[current].forEach {
            if (it == destination) {
                return true
            }
            if (!visited[it]) {
                queue.addLast(it)
            }
        }
    }
    return false
}

private fun main() {

}
