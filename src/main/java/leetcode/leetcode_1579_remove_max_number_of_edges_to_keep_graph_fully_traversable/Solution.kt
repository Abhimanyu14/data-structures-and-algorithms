package leetcode.leetcode_1579_remove_max_number_of_edges_to_keep_graph_fully_traversable

/**
 * leetcode - https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/?envType=daily-question&envId=2024-06-30
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 630 ms, faster than 100.00%
 * Memory Usage: 93.7 MB, less than 100.00%
 *
 * Time -
 * Space -
 */

private class UnionFind(
    val n: Int,
) {
    private val root = IntArray(n) { it }
    private val rank = IntArray(n)
    var trees = n

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x]) // Concept - Path compression
        }
        return root[x]
    }

    fun union(x: Int, y: Int): Int {
        var rootX = find(x)
        var rootY = find(y)

        // rootX == rootY => they are already in same tree
        if (rootX == rootY) {
            return 0
        } else {
            // Checking tree with smaller number of nodes
            if (rank[rootX] < rank[rootY]) {
                rootX = rootY.also {
                    rootY = rootX
                }
            }

            // Attaching lower rank tree to the higher one.
            root[rootY] = rootX

            // If now ranks are equal increasing rank of X.
            if (rank[rootX] == rank[rootY]) {
                rank[rootX]++
            }
            trees--
            return 1
        }
    }
}

private fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
    var result = 0
    val aliceGraph = UnionFind(n)
    val bobGraph = UnionFind(n)
    edges.forEach { (type, from, to) ->
        if (type == 3) {
            if (aliceGraph.union(from - 1, to - 1) == 0 || bobGraph.union(from - 1, to - 1) == 0) {
                result++
            }
        }
    }
    edges.forEach { (type, from, to) ->
        if (type == 1) {
            if (aliceGraph.union(from - 1, to - 1) == 0) {
                result++
            }
        } else if (type == 2) {
            if (bobGraph.union(from - 1, to - 1) == 0) {
                result++
            }
        }
    }
    return if (aliceGraph.trees != 1 || bobGraph.trees != 1) {
        -1
    } else {
        result
    }
}

private fun main() {

}
