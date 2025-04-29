package leetcode.leetcode_684_redundant_connection

/**
 * leetcode - https://leetcode.com/problems/redundant-connection/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - UnionFind (DSU) - Disjoint Set Union
 * Algorithm - UnionFind (DSU) - Disjoint Set Union
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 178 ms, faster than 38.33%
 * Memory Usage: 36.5 MB, less than 98.33%
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private class UnionFind(n: Int) {
    private val root = IntArray(n) { it }
    private val rank = IntArray(n)

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x])
        }
        return root[x]
    }

    fun union(x: Int, y: Int): Int {
        var rootX = find(x)
        var rootY = find(y)
        if (rootX == rootY) {
            return 0
        } else {
            if (rank[rootX] < rank[rootY]) {
                rootX = rootY.also {
                    rootY = rootX
                }
            }
            root[rootY] = rootX
            if (rank[rootX] == rank[rootY]) {
                rank[rootX]++
            }
            return 1
        }
    }
}

private fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val unionFind = UnionFind(edges.size)
    for (edge in edges) {
        if (unionFind.union(edge[0] - 1, edge[1] - 1) == 0) {
            return edge
        }
    }
    return intArrayOf()
}

private fun main() {

}
