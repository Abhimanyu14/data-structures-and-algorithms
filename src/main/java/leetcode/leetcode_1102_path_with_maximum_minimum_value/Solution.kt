package leetcode.leetcode_1102_path_with_maximum_minimum_value

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/path-with-maximum-minimum-value/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Grid
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google
 */
private fun maximumMinimumPath(grid: Array<IntArray>): Int {
    val result = Array(grid.size) {
        IntArray(grid[0].size)
    }
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.addLast(Triple(0, 0, grid[0][0]))
    var candidate: Int
    while (queue.isNotEmpty()) {
        val (x, y, score) = queue.removeFirst()
        if (result[x][y] >= score) {
            continue
        }
        result[x][y] = score
        if (x > 0) {
            candidate = min(grid[x - 1][y], result[x][y])
            if (result[x - 1][y] < candidate) {
                queue.addLast(Triple(x - 1, y, candidate))
            }
        }
        if (x < grid.lastIndex) {
            candidate = min(grid[x + 1][y], result[x][y])
            if (result[x + 1][y] < candidate) {
                queue.addLast(Triple(x + 1, y, candidate))
            }
        }
        if (y > 0) {
            candidate = min(grid[x][y - 1], result[x][y])
            if (result[x][y - 1] < min(grid[x][y - 1], result[x][y])) {
                queue.addLast(Triple(x, y - 1, candidate))
            }
        }
        if (y < grid[0].lastIndex) {
            candidate = min(grid[x][y + 1], result[x][y])
            if (result[x][y + 1] < candidate) {
                queue.addLast(Triple(x, y + 1, candidate))
            }
        }
    }
    return result.last().last()
}

private fun main() {

}
