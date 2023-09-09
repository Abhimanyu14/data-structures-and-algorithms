package leetcode.leet_500_to_599.leet_547_number_of_provinces

/**
 * leetcode - https://leetcode.com/problems/number-of-provinces/
 *
 * Using UnionFind (DSU)
 *
 * Stats
 * Runtime: 324 ms, faster than 5.43%
 * Memory Usage: 52.1 MB, less than 5.43%
 */
private class UnionFind (n : Int) {
    val root = IntArray(n) { it }
    val rank = IntArray(n)

    fun find (x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x])
        }
        return root[x]
    }

    fun union (x: Int, y: Int): Int {
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

private fun findCircleNum(isConnected: Array<IntArray>): Int {
    var result = isConnected.size
    val unionFind = UnionFind(isConnected.size)

    for (i in 0..isConnected.lastIndex) {
        for (j in (i + 1)..isConnected.lastIndex) {
            if (isConnected[i][j] == 1) {
                result -= unionFind.union(i, j)
            }
        }
    }

    return result
}

private fun main() {

}
