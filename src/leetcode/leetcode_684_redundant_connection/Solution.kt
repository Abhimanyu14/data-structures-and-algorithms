package leetcode.leetcode_684_redundant_connection

/**
 * leetcode - https://leetcode.com/problems/redundant-connection/
 *
 * Using UnionFind (DSU) - Disjoint Set Union
 *
 * Stats
 * Runtime: 178 ms, faster than 38.33%
 * Memory Usage: 36.5 MB, less than 98.33%
 */
private class UnionFind(
    val n: Int,
) {
    private val root = IntArray(n) { it }
    private val rank = IntArray(n)

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x])
        }
        return root[x]
    }

    fun union(x: Int, y: Int): Boolean {
        var rootX = find(x)
        var rootY = find(y)

        return if (rootX == rootY) {
            true
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
            false
        }
    }
}

private fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val unionFind = UnionFind(edges.size)
    edges.forEach {
        if (unionFind.union(it[0] - 1, it[1] - 1)) {
            return it
        }
    }
    return intArrayOf()
}

private fun main() {

}
