package leetcode.leetcode_1091_shortest_path_in_binary_matrix

/**
 * leetcode - https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * Data Structure - Grid, Graph (2D Array)
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    if (grid[0][0] == 1 || grid[grid.lastIndex][grid[0].lastIndex] == 1) {
        return -1
    }
    if (grid.lastIndex == 0 && grid[0].lastIndex == 0) {
        return 1
    }
    val visited = Array(grid.size) {
        BooleanArray(grid[0].size)
    }
    val directions = arrayOf(
        intArrayOf(1, 1), intArrayOf(0, 1), intArrayOf(-1, 1), intArrayOf(-1, 0),
        intArrayOf(-1, -1), intArrayOf(0, -1), intArrayOf(1, -1), intArrayOf(1, 0),
    )

    val queue = ArrayDeque<Triple<Int, Int, Int>>() // x, y, distance
    queue.addLast(Triple(0, 0, 1))
    while (queue.isNotEmpty()) {
        val (x, y, distance) = queue.removeFirst()
        if (visited[x][y]) {
            continue
        }
        visited[x][y] = true
        for ((x1, y1) in directions) {
            if ((x + x1) == grid.lastIndex && (y + y1) == grid[0].lastIndex) {
                return distance + 1
            }
            if ((x + x1) in 0..grid.lastIndex &&
                (y + y1) in 0..grid[0].lastIndex &&
                !visited[x + x1][y + y1] &&
                grid[x + x1][y + y1] == 0
            ) {
                queue.add(Triple(x + x1, y + y1, distance + 1))
            }
        }
    }
    return -1
}

private fun main() {

}
