package leetcode.leet_600_to_699.leet_684_redundant_connection

/**
 * leetcode - https://leetcode.com/problems/redundant-connection/
 *
 * Using UnionFind (DSU)
 *
 * Stats
 * Runtime: 194 ms, faster than 18.37%
 * Memory Usage: 36.5 MB, less than 81.63%
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

    fun union(x: Int, y: Int): Int {
        var rootX = find(x)
        var rootY = find(y)

        return if (rootX == rootY) {
            0
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
            1
        }
    }

    fun findAll(): List<Int> {
        return buildList {
            repeat(n) {
                add(find(it))
            }
        }
    }
}

private fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val unionFind = UnionFind(edges.size)
    edges.forEach {
        if (unionFind.union(it[0] - 1, it[1] - 1) == 0) {
            return it
        }
    }
    return intArrayOf()
}

private fun main() {

}
