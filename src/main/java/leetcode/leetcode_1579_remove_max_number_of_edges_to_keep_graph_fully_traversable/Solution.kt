package leetcode.leetcode_1579_remove_max_number_of_edges_to_keep_graph_fully_traversable

/**
 * leetcode - https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/?envType=daily-question&envId=2024-06-30
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Union Find
 * Algorithm - Union Find
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 630 ms, faster than 100.00%
 * Memory Usage: 93.7 MB, less than 100.00%
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

private fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
    var result = 0
    val aliceGraph = UnionFind(n)
    val bobGraph = UnionFind(n)

    var aliceTrees = n
    var bobTrees = n
    for ((type, from, to) in edges) {
        if (type == 3) {
            aliceGraph.union(from - 1, to - 1)
            val canBeRemoved = bobGraph.union(from - 1, to - 1) == 0
            if (canBeRemoved) {
                result++
                aliceTrees--
                bobTrees--
            }
        }
    }
    for ((type, from, to) in edges) {
        if (type == 1) {
            if (aliceGraph.union(from - 1, to - 1) == 0) {
                result++
                aliceTrees--
            }
        } else if (type == 2) {
            if (bobGraph.union(from - 1, to - 1) == 0) {
                result++
                bobTrees--
            }
        }
    }
    return if (aliceTrees != 1 || bobTrees != 1) {
        -1
    } else {
        result
    }
}

private fun main() {

}
