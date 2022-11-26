package leetcode.leet_200_number_of_islands

/**
 * Using loops and array manipulation
 *
 * Stats
 * Runtime: 437 ms, faster than 66.08%
 * Memory Usage: 55.1 MB, less than 67.31%
 */
private fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    grid.forEachIndexed { rowIndex, chars ->
        chars.forEachIndexed { colIndex, c ->
            if (grid[rowIndex][colIndex] == '1') {
                count++
                clearIsland(grid, rowIndex, colIndex)
            }
        }
    }
    return count
}

private fun clearIsland(grid: Array<CharArray>, row: Int, col: Int) {
    grid[row][col] = '0'
    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
        clearIsland(grid, row - 1, col)
    }
    if (row + 1 < grid.size && grid[row + 1][col] == '1') {
        clearIsland(grid, row + 1, col)
    }
    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
        clearIsland(grid, row, col - 1)
    }
    if (col + 1 < grid[row].size && grid[row][col + 1] == '1') {
        clearIsland(grid, row, col + 1)
    }
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
