package leetcode.leetcode_0_to_99.leetcode_37_sudoku_solver

/**
 * leetcode - https://leetcode.com/problems/sudoku-solver/
 *
 * Using backtracking, list and set
 *
 * Stats
 * Runtime: 292 ms, faster than 24.59%
 * Memory Usage: 43 MB, less than 18.03%
 */
private fun solveSudoku(board: Array<CharArray>) {
    val emptyIndices = mutableListOf<Pair<Int, Int>>()
    board.forEachIndexed { row, rowChars ->
        rowChars.forEachIndexed { col, cell ->
            if (cell == '.') {
                emptyIndices.add(Pair(row, col))
            }
        }
    }
    if (emptyIndices.isEmpty()) {
        return
    }

    fun getValidNumbers(x: Int, y: Int): List<Char> {
        val currentSet = mutableSetOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
        for (i in 0 until 9) {
            if (board[x][i] != '.') {
                currentSet.remove(board[x][i])
            }
            if (board[i][y] != '.') {
                currentSet.remove(board[i][y])
            }
        }
        val boxStartX = x / 3
        val boxStartY = y / 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (board[boxStartX * 3 + i][boxStartY * 3 + j] != '.') {
                    currentSet.remove(board[boxStartX * 3 + i][boxStartY * 3 + j])
                }
            }
        }
        return currentSet.toList()
    }

    fun solve(currentIndex: Int): Boolean {
        if (currentIndex == emptyIndices.size) {
            return true
        }
        val xPos = emptyIndices[currentIndex].first
        val yPos = emptyIndices[currentIndex].second
        val validNumbers = getValidNumbers(xPos, yPos)
        if (validNumbers.isEmpty()) {
            return false
        }
        validNumbers.forEach {
            board[xPos][yPos] = it
            if (solve(currentIndex + 1)) {
                return true
            } else {
                board[xPos][yPos] = '.'
            }
        }
        return false
    }
    solve(0)
}

private fun main() {

}
