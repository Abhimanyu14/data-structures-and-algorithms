package leetcode.leetcode_261_graph_valid_tree

/**
 * leetcode - https://leetcode.com/problems/graph-valid-tree/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 * Premium Question
 *
 * Data Structure - Graph, [Array], [List], [Set]
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    if (edges.size != n - 1) {
        return false
    }
    val graph = Array(n) {
        mutableListOf<Int>()
    }
    for ((from, to) in edges) {
        graph[from].add(to)
        graph[to].add(from)
    }
    val visited = mutableSetOf<Int>()
    fun dfs(current: Int) {
        if (visited.contains(current)) {
            return
        }
        visited.add(current)
        graph[current].forEach {
            if (!visited.contains(it)) {
                dfs(it)
            }
        }
    }
    dfs(0)
    return visited.size == n
}

private fun main() {

}
