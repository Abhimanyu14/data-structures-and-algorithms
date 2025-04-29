package leetcode.leetcode_1101_the_earliest_moment_when_everyone_become_friends

/**
 * leetcode - https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Union Find
 * Algorithm - Union Find
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 264 ms, faster than 20.83%
 * Memory Usage: 46.2 MB, less than 8.33%
 *
 * Time -
 * Space -
 *
 * Companies - Google
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

private fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
    val unionFind = UnionFind(n)
    var groups = n
    val sortedLogs = logs.sortedBy { it[0] }
    for ((timestamp, a, b) in sortedLogs) {
        groups -= unionFind.union(a, b)
        if (groups == 1) {
            return timestamp
        }
    }
    return -1
}

private fun main() {

}
