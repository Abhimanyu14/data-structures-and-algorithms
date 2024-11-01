package leetcode.leetcode_100_to_199.leetcode_130_surrounded_regions

/**
 * leetcode - https://leetcode.com/problems/surrounded-regions/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 237 ms, faster than 37.37%
 * Memory Usage: 49.7 MB, less than 13.13%
 */
private fun solve(board: Array<CharArray>) {
    val rows = board.size
    val cols = board[0].size
    val visited = Array(rows) { Array(cols) { false } }
    val currentRegion = mutableSetOf<Pair<Int, Int>>()

    fun checkForCapture(row: Int, col: Int): Boolean {
        visited[row][col] = true
        currentRegion.add(Pair(row, col))

        var result = row > 0 && col > 0 && row < rows - 1 && col < cols - 1
        if (row > 0 && !visited[row - 1][col] && board[row - 1][col] == 'O') {
            result = checkForCapture(row - 1, col) && result
        }
        if (row < rows - 1 && !visited[row + 1][col] && board[row + 1][col] == 'O') {
            result = checkForCapture(row + 1, col) && result
        }
        if (col > 0 && !visited[row][col - 1] && board[row][col - 1] == 'O') {
            result = checkForCapture(row, col - 1) && result
        }
        if (col < cols - 1 && !visited[row][col + 1] && board[row][col + 1] == 'O') {
            result = checkForCapture(row, col + 1) && result
        }
        return result
    }

    fun capture() {
        currentRegion.forEach { (x, y) ->
            board[x][y] = 'X'
        }
    }

    board.forEachIndexed { row, items ->
        items.forEachIndexed { col, item ->
            if (item == 'O' && !visited[row][col] && checkForCapture(row, col)) {
                capture()
            }
            currentRegion.clear()
        }
    }
}

private fun main() {
    solve(
        arrayOf(
            charArrayOf('O', 'O', 'O', 'O', 'X', 'X'),
            charArrayOf('O', 'O', 'O', 'O', 'O', 'O'),
            charArrayOf('O', 'X', 'O', 'X', 'O', 'O'),
            charArrayOf('O', 'X', 'O', 'O', 'X', 'O'),
            charArrayOf('O', 'X', 'O', 'X', 'O', 'O'),
            charArrayOf('O', 'X', 'O', 'O', 'O', 'O'),
        )
    )
}
