package leetcode.leetcode_323_number_of_connected_components_in_an_undirected_graph

/**
 * leetcode - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 *
 * TODO(Abhi) - To revisit
 *
 * Using DFS
 *
 * Stats
 *
 */

/**
 * leetcode - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 *
 * Using Disjoint Set Union (DSU) aka Union Find
 *
 * Stats
 * Runtime: 162 ms, faster than 98.72%
 * Memory Usage: 37.1 MB, less than 92.31%
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

private fun countComponents(n: Int, edges: Array<IntArray>): Int {
    var result = n
    val unionFind = UnionFind(n)
    edges.forEach {
        result -= unionFind.union(it[0], it[1])
    }
    return result
}

private fun main() {
    println(
        countComponents(
            6, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(2, 5),
                intArrayOf(3, 4),
                intArrayOf(3, 5),
            )
        )
    )
}
