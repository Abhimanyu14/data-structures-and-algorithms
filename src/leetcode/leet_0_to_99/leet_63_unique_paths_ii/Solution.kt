package leetcode.leet_0_to_99.leet_63_unique_paths_ii

/**
 * leetcode - https://leetcode.com/problems/unique-paths-ii/
 *
 * Using dynamic programming - tabulation
 *
 * Stats
 * Runtime: 217 ms, faster than 51.79%
 * Memory Usage: 42.9 MB, less than 7.14%
 */
private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
        return 0
    }
    obstacleGrid[0][0] = 1
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == 0 && j == 0) {
                continue
            }
            if (obstacleGrid[i][j] == 1) {
                obstacleGrid[i][j] = -1
            } else {
                if (i != 0 && obstacleGrid[i - 1][j] != -1) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j]
                }
                if (j != 0 && obstacleGrid[i][j - 1] != -1) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1]
                }
            }
        }
    }
    return obstacleGrid[m - 1][n - 1]
}

private fun main() {

}
