package leetcode.leet_400_to_499.leet_463_island_perimeter

/**
 * leetcode - https://leetcode.com/problems/island-perimeter/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 363 ms, faster than 100.00%
 * Memory Usage: 44.2 MB, less than 100.00%
 */
private fun islandPerimeter(grid: Array<IntArray>): Int {
    var result = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                if (i == 0 || grid[i - 1][j] == 0) {
                    result++
                }
                if (j == 0 || grid[i][j - 1] == 0) {
                    result++
                }
                if (i == grid.lastIndex || grid[i + 1][j] == 0) {
                    result++
                }
                if (j == grid[0].lastIndex || grid[i][j + 1] == 0) {
                    result++
                }
            }
        }
    }
    return result
}

private fun main() {

}
