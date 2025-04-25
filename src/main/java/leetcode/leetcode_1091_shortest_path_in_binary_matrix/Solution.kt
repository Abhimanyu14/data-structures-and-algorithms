package leetcode.leetcode_1091_shortest_path_in_binary_matrix

/**
 * leetcode - https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * Data Structure - Graph (2D Array)
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
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

    fun getAdjacentPoints(x: Int, y: Int): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        if (x > 0) {
            if (y > 0 && grid[x - 1][y - 1] == 0 && !visited[x - 1][y - 1]) {
                result.add(Pair(x - 1, y - 1))
            }
            if (grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                result.add(Pair(x - 1, y))
            }
            if (y < grid[0].lastIndex && grid[x - 1][y + 1] == 0 && !visited[x - 1][y + 1]) {
                result.add(Pair(x - 1, y + 1))
            }
        }
        if (y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
            result.add(Pair(x, y - 1))
        }
        if (y < grid[0].lastIndex && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
            result.add(Pair(x, y + 1))
        }
        if (x < grid.lastIndex) {
            if (y > 0 && grid[x + 1][y - 1] == 0 && !visited[x + 1][y - 1]) {
                result.add(Pair(x + 1, y - 1))
            }
            if (grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                result.add(Pair(x + 1, y))
            }
            if (y < grid[0].lastIndex && grid[x + 1][y + 1] == 0 && !visited[x + 1][y + 1]) {
                result.add(Pair(x + 1, y + 1))
            }
        }
        return result
    }

    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.addLast(Triple(0, 0, 1))
    while (queue.isNotEmpty()) {
        val (x, y, distance) = queue.removeFirst()
        if (visited[x][y]) {
            continue
        }
        visited[x][y] = true
        getAdjacentPoints(x, y).forEach { (x1, y1) ->
            if (x1 == grid.lastIndex && y1 == grid[0].lastIndex) {
                return distance + 1
            }
            queue.add(Triple(x1, y1, distance + 1))
        }
    }
    return -1
}

private fun main() {

}
