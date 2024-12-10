package leetcode.leetcode_1101_the_earliest_moment_when_everyone_become_friends

/**
 * leetcode - https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Using UnionFind (DSU)
 *
 * Stats
 * Runtime: 264 ms, faster than 20.83%
 * Memory Usage: 46.2 MB, less than 8.33%
 */
private class UnionFind(n: Int) {
    val root = IntArray(n) { it }
    val rank = IntArray(n)

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x])
        }
        return root[x]
    }

    fun union(x: Int, y: Int): Int {
        println("$x, $y")
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

private fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
    val unionFind = UnionFind(n)
    var groups = n

    logs.sortedBy {
        it[0]
    }.forEach {
        groups -= unionFind.union(it[1], it[2])
        if (groups == 1) {
            return it[0]
        }
    }

    return -1
}

private fun main() {

}
