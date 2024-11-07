package leetcode.leetcode_1905_count_sub_islands

/**
 * leetcode - https://leetcode.com/problems/count-sub-islands/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */

private class Solution {
    // Directions in which we can traverse inside the grids.
    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    // Helper method to check if the cell at the position (x, y) in the 'grid'
    // is a land cell.
    private fun isCellLand(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        return grid[x][y] == 1
    }

    // Union-Find class.
    internal inner class UnionFind(n: Int) {
        private val parent = IntArray(n)
        private val rank = IntArray(n)

        // Initialize union-find object with 'n' elements.
        init {
            for (i in 0 until n) {
                parent[i] = i
                rank[i] = 0
            }
        }

        // Find the root of element 'u', using the path-compression technique.
        fun find(u: Int): Int {
            if (parent[u] != u) {
                parent[u] = find(parent[u])
            }
            return parent[u]
        }

        // Union two components of elements 'u' and 'v' respectively based on
        // their ranks.
        fun unionSets(u: Int, v: Int) {
            val rootU = find(u)
            val rootV = find(v)
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV
                } else {
                    parent[rootV] = rootU
                    rank[rootU]++
                }
            }
        }
    }

    // Helper method to convert (x, y) position to a 1-dimensional index.
    private fun convertToIndex(x: Int, y: Int, totalCols: Int): Int {
        return x * totalCols + y
    }

    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val totalRows = grid2.size
        val totalCols = grid2[0].size
        val uf: UnionFind = UnionFind(totalRows * totalCols)

        // Traverse each land cell of 'grid2'.
        for (x in 0 until totalRows) {
            for (y in 0 until totalCols) {
                if (isCellLand(x, y, grid2)) {
                    // Union adjacent land cells with the current land cell.
                    for (direction in directions) {
                        val nextX = x + direction[0]
                        val nextY = y + direction[1]
                        if (nextX >= 0 && nextY >= 0 && nextX < totalRows && nextY < totalCols &&
                            isCellLand(nextX, nextY, grid2)
                        ) {
                            uf.unionSets(
                                convertToIndex(x, y, totalCols),
                                convertToIndex(nextX, nextY, totalCols)
                            )
                        }
                    }
                }
            }
        }

        // Traverse 'grid2' land cells and mark that cell's root as not a sub-island
        // if the land cell is not present at the respective position in 'grid1'.
        val isSubIsland = BooleanArray(totalRows * totalCols)
        for (i in isSubIsland.indices) {
            isSubIsland[i] = true
        }
        for (x in 0 until totalRows) {
            for (y in 0 until totalCols) {
                if (isCellLand(x, y, grid2) && !isCellLand(x, y, grid1)) {
                    val root = uf.find(convertToIndex(x, y, totalCols))
                    isSubIsland[root] = false
                }
            }
        }

        // Count all the sub-islands.
        var subIslandCounts = 0
        for (x in 0 until totalRows) {
            for (y in 0 until totalCols) {
                if (isCellLand(x, y, grid2)) {
                    val root = uf.find(convertToIndex(x, y, totalCols))
                    if (isSubIsland[root]) {
                        subIslandCounts++
                        // One cell can be the root of multiple land cells, so to
                        // avoid counting the same island multiple times, mark it as false.
                        isSubIsland[root] = false
                    }
                }
            }
        }

        return subIslandCounts
    }
}

private fun main() {

}
