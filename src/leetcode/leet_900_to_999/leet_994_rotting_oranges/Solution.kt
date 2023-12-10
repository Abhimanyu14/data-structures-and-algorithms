package leetcode.leet_900_to_999.leet_994_rotting_oranges

/**
 * leetcode - https://leetcode.com/problems/rotting-oranges/
 *
 * Using In place BFS
 *
 * Stats
 * Runtime: 300 ms, faster than 72.22%
 * Memory Usage: 36.1 MB, less than 84.72%
 */
private fun orangesRotting(grid: Array<IntArray>): Int {
    var timestamp = 2
    fun rot(): Boolean {
        var changed = false
        val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        grid.forEachIndexed { i, row ->
            row.forEachIndexed { j, cell ->
                if (cell == timestamp) {
                    directions.forEach { direction ->
                        val tRow = i + direction[0]
                        val tCol = j + direction[1]
                        if ((tRow in grid.indices) && (tCol in grid[0].indices)) {
                            if (grid[tRow][tCol] == 1) {
                                grid[tRow][tCol] = timestamp + 1
                                changed = true
                            }
                        }
                    }
                }
            }
        }
        return changed
    }

    // Wait for all oranges to rot
    while (rot()) {
        timestamp++
    }

    // Check if fresh oranges are left
    for (row in grid) {
        for (cell in row) {
            if (cell == 1) {
                return -1
            }
        }
    }
    return timestamp - 2
}

private fun main() {

}
