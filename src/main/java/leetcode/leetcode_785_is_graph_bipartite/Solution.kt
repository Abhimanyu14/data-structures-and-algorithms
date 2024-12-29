package leetcode.leetcode_785_is_graph_bipartite

/**
 * leetcode - https://leetcode.com/problems/is-graph-bipartite/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 244 ms, faster than 18.18%
 * Memory Usage: 46.3 MB, less than 9.09%
 */
private fun isBipartite(graph: Array<IntArray>): Boolean {
    val n = graph.size
    val color = IntArray(n) { -1 }
    for (start in 0..<n) {
        if (color[start] == -1) {
            val stack = ArrayDeque<Int>()
            stack.addLast(start)
            color[start] = 0
            while (stack.isNotEmpty()) {
                val node = stack.removeLast()
                graph[node].forEach {
                    if (color[it] == -1) {
                        stack.addLast(it)
                        color[it] = color[node] xor 1
                    } else if (color[it] == color[node]) {
                        return false
                    }
                }
            }
        }
    }
    return true
}
private fun main() {

}
