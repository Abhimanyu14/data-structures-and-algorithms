package leetcode.leetcode_685_redundant_connection_ii

/**
 * leetcode - https://leetcode.com/problems/redundant-connection-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private class UnionFind(private val n: Int) {
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
                root[rootY] = rootX
                if (root[rootX] == root[rootY]) {
                    root[rootX]++
                }
            }
            return 1
        }
    }
}

class Solution {
    fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
        val inDegrees = IntArray(edges.size)
        val unionFind = UnionFind(edges.size)
        for (edge in edges) {
            if (inDegrees[edge[1] - 1] > 0) {
                return edge
            }
            if (unionFind.union(edge[0] - 1, edge[1] - 1) == 0) {
                return edge
            }
            inDegrees[edge[1] - 1]++
        }
        return intArrayOf()
    }
}

private fun main() {

}
