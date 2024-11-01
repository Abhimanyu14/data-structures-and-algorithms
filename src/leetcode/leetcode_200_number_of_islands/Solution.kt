package leetcode.leetcode_200_number_of_islands

/**
 * leetcode - https://leetcode.com/problems/number-of-islands/
 *
 * Using input array manipulation
 *
 * Stats
 * Runtime: 214 ms, faster than 64.73%
 * Memory Usage: 43.8 MB, less than 97.83%
 */
private fun numIslands(grid: Array<CharArray>): Int {
    var result = 0
    fun clearIsland(row: Int, col: Int) {
        grid[row][col] = '0'
        if (row > 0 && grid[row - 1][col] == '1') {
            clearIsland(row - 1, col)
        }
        if (row < grid.lastIndex && grid[row + 1][col] == '1') {
            clearIsland(row + 1, col)
        }
        if (col > 0 && grid[row][col - 1] == '1') {
            clearIsland(row, col - 1)
        }
        if (col < grid[row].lastIndex && grid[row][col + 1] == '1') {
            clearIsland(row, col + 1)
        }
    }
    grid.forEachIndexed { rowIndex, chars ->
        chars.forEachIndexed { colIndex, char ->
            if (char == '1') {
                result++
                clearIsland(rowIndex, colIndex)
            }
        }
    }
    return result
}

private fun main() {
    val input1 = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0'),
    )
    val input2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1'),
    )
    val input3 = arrayOf(
        charArrayOf('1', '1', '1'),
        charArrayOf('0', '1', '0'),
        charArrayOf('1', '1', '1'),
    )
    println(numIslands(input1) == 1)
    println(numIslands(input2) == 3)
    println(numIslands(input3) == 1)
}
