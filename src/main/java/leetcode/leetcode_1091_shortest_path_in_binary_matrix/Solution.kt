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
    if (grid[0][0] == 1) {
        return -1
    }
    val distanceGrid = Array(grid.size) { IntArray(grid[0].size) { Int.MAX_VALUE } }
    val queue = ArrayDeque<Triple<Int, Int, Int>>() // x, y, distance
    fun getNextPositions(x: Int, y: Int, distance: Int): List<Triple<Int, Int, Int>> {
        val positions = mutableListOf<Triple<Int, Int, Int>>()
        if (x > 0) {
            if (y > 0 && grid[x - 1][y - 1] == 0 && distanceGrid[x - 1][y - 1] > distance + 1) {
                positions.add(Triple(x - 1, y - 1, distance + 1))
            }
            if (grid[x - 1][y] == 0 && distanceGrid[x - 1][y] > distance + 1) {
                positions.add(Triple(x - 1, y, distance + 1))
            }
            if (y < grid[0].lastIndex && grid[x - 1][y + 1] == 0 && distanceGrid[x - 1][y + 1] > distance + 1) {
                positions.add(Triple(x - 1, y + 1, distance + 1))
            }
        }
        if (y > 0 && grid[x][y - 1] == 0 && distanceGrid[x][y - 1] > distance + 1) {
            positions.add(Triple(x, y - 1, distance + 1))
        }
        if (y < grid[0].lastIndex && grid[x][y + 1] == 0 && distanceGrid[x][y + 1] > distance + 1) {
            positions.add(Triple(x, y + 1, distance + 1))
        }
        if (x < grid.lastIndex) {
            if (y > 0 && grid[x + 1][y - 1] == 0 && distanceGrid[x + 1][y - 1] > distance + 1) {
                positions.add(Triple(x + 1, y - 1, distance + 1))
            }
            if (grid[x + 1][y] == 0 && distanceGrid[x + 1][y] > distance + 1) {
                positions.add(Triple(x + 1, y, distance + 1))
            }
            if (y < grid[0].lastIndex && grid[x + 1][y + 1] == 0 && distanceGrid[x + 1][y + 1] > distance + 1) {
                positions.add(Triple(x + 1, y + 1, distance + 1))
            }
        }
        return positions
    }
    queue.addLast(Triple(0, 0, 1))
    while (queue.isNotEmpty()) {
        val (x, y, distance) = queue.removeFirst()
        if (distanceGrid[x][y] > distance) {
            distanceGrid[x][y] = distance
            getNextPositions(x, y, distance).forEach {
                queue.addLast(it)
            }
        }
    }
    return if (distanceGrid[grid.lastIndex][grid[0].lastIndex] == Int.MAX_VALUE) {
        -1
    } else {
        distanceGrid[grid.lastIndex][grid[0].lastIndex]
    }
}

private fun main() {

}
