package leetcode.leet_1000_to_1099.leet_1020_number_of_enclaves

/**
 * leetcode - https://leetcode.com/problems/number-of-enclaves/
 *
 * Using BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 77 ms, faster than 100.00%
 * Memory Usage: 73.2 MB, less than 17.86%
 *
 * Time -
 * Space -
 */
private fun numEnclaves(grid: Array<IntArray>): Int {
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun traverse(row: Int, col: Int) {
        if (row < 0 || col < 0 || row > grid.lastIndex || col > grid[0].lastIndex) {
            return
        }
        if (visited.contains(Pair(row, col))) {
            return
        }
        visited.add(Pair(row, col))
        if (grid[row][col] == 1) {
            traverse(row - 1, col)
            traverse(row + 1, col)
            traverse(row, col - 1)
            traverse(row, col + 1)
        }
    }

    for (i in 0..grid.lastIndex) {
        traverse(i, 0)
        traverse(i, grid[0].lastIndex)
    }
    for (i in 0..grid[0].lastIndex) {
        traverse(0, i)
        traverse(grid.lastIndex, i)
    }

    var result = 0
    for (i in 1..<grid.lastIndex) {
        for (j in 1..<grid[0].lastIndex) {
            if (grid[i][j] == 1 && !visited.contains(Pair(i, j))) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
