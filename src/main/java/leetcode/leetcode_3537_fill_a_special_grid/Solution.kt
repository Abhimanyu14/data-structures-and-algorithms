package leetcode.leetcode_3537_fill_a_special_grid

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/fill-a-special-grid/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * N - Number of element in grid
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun specialGrid(n: Int): Array<IntArray> {
    val size = (2.0).pow(n).toInt()
    val grid = Array(size) {
        IntArray(size)
    }
    fun fill(smallest: Int, largest: Int, x1: Int, y1: Int, x2: Int, y2: Int) {
        if (x1 == x2 && y1 == y2) {
            grid[x1][y1] = smallest
            return
        }
        val range = largest - smallest + 1
        val subSize = x2 - x1 + 1
        fill( // 0
            smallest,
            smallest + (range / 4) - 1,
            x1,
            y1 + (subSize / 2),
            x1 + (subSize / 2) - 1,
            y2,
        )
        fill( // 1
            smallest + (range / 4),
            smallest + ((2 * range) / 4) - 1,
            (x1 + subSize / 2),
            y1 + (subSize / 2),
            x2,
            y2,
        )
        fill( // 2
            smallest + ((2 * range) / 4),
            smallest + ((3 * range) / 4) - 1,
            (x1 + subSize / 2),
            y1,
            x2,
            y1 + (subSize / 2) - 1,
        )
        fill( // 3
            smallest + ((3 * range) / 4),
            smallest + range - 1,
            x1,
            y1,
            x1 + (subSize / 2) - 1,
            y1 + (subSize / 2) - 1,
        )
    }
    fill(0, (2.0).pow(2 * n).toInt() - 1, 0, 0, size - 1, size - 1)
    return grid
}

private fun main() {

}
