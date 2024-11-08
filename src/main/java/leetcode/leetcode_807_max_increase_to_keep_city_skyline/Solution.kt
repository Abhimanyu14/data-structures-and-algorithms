package leetcode.leetcode_807_max_increase_to_keep_city_skyline

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 *
 * Using iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 37.7 MB, less than 100.00%
 *
 * Time - O(M * N)
 * Space - O(M * N)
 */
private fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    var result = 0
    val rowMax = IntArray(grid.size)
    val colMax = IntArray(grid[0].size)

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            rowMax[i] = max(rowMax[i], grid[i][j])
            colMax[j] = max(colMax[j], grid[i][j])
        }
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            result += (min(rowMax[i], colMax[j]) - grid[i][j])
        }
    }

    return result
}

private fun main() {

}
