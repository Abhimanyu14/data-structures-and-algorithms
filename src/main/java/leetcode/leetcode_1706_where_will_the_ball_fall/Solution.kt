package leetcode.leetcode_1706_where_will_the_ball_fall

/**
 * leetcode - https://leetcode.com/problems/where-will-the-ball-fall/
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 18 ms, faster than 75.00%
 * Memory Usage: 45.4 MB, less than 0.00%
 *
 * Time -
 * Space -
 */
private fun findBall(grid: Array<IntArray>): IntArray {
    val result = IntArray(grid[0].size) { it }
    fun getNextPosition(row: Int, col: Int): Int {
        return when {
            (grid[row][col] == 1) && (col != grid[0].lastIndex) && (grid[row][col + 1] != -1) -> col + 1
            (grid[row][col] == -1) && (col != 0) && (grid[row][col - 1] != 1) -> col - 1
            else -> -1
        }
    }
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (result[j] != -1) {
                result[j] = getNextPosition(i, result[j])
            }
        }
    }
    return result
}

private fun main() {

}
