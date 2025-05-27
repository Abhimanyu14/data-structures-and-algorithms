package leetcode.leetcode_2923_find_champion_i

/**
 * leetcode - https://leetcode.com/problems/find-champion-i/description/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * N: grid.size
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun findChampion(grid: Array<IntArray>): Int {
    var result = 0
    for (i in 1..grid.lastIndex) {
        if (grid[result][i] == 0) {
            result = i
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/find-champion-i/description/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * N: grid.size
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun findChampionUsingTwoLoops(grid: Array<IntArray>): Int {
    for (i in grid.indices) {
        var count = 0
        for (j in grid[0].indices) {
            count += grid[i][j]
        }
        if (count == grid.lastIndex) {
            return i
        }
    }
    return -1
}

private fun main() {

}
