package leetcode.leetcode_547_number_of_provinces

/**
 * leetcode - https://leetcode.com/problems/number-of-provinces/
 *
 * Using UnionFind (DSU)
 *
 * Stats
 * Runtime: 324 ms, faster than 5.43%
 * Memory Usage: 52.1 MB, less than 5.43%
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

/**
 * leetcode - https://leetcode.com/problems/number-of-provinces/
 *
 * Using BFS
 *
 * Stats
 * Runtime: 26 ms, faster than 11.11%
 * Memory Usage: 50.5 MB, less than 5.23%
 */
private fun findCircleNumUsingBfs(isConnected: Array<IntArray>): Int {
    var result = 0
    val visited = mutableSetOf<Int>()
    val queue = ArrayDeque<Int>()
    repeat(isConnected.size) { node ->
        if (!visited.contains(node)) {
            queue.addLast(node)
            visited.add(node)
            result++
        }
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            isConnected[current].forEachIndexed { index, item ->
                if (item == 1 && !visited.contains(index)) {
                    queue.addLast(index)
                    visited.add(index)
                }
            }
        }
    }
    return result
}

private fun main() {

}
