package leetcode.leetcode_0_to_99.leetcode_36_valid_sudoku

/**
 * leetcode - https://leetcode.com/problems/valid-sudoku/
 *
 * Using loops
 *
 * Stats
 * Runtime: 201 ms, faster than 48.50%
 * Memory Usage: 38.1 MB, less than 63.30%
 */
private fun isValidSudoku(board: Array<CharArray>): Boolean {
    fun rowCheck(x: Int, y: Int): Boolean {
        for (i in 0..8) {
            if (i != y && board[x][y] == board[x][i]) {
                return false
            }
        }
        return true
    }

    fun colCheck(x: Int, y: Int): Boolean {
        for (i in 0..8) {
            if (i != x && board[x][y] == board[i][y]) {
                return false
            }
        }
        return true
    }

    fun boxCheck(x: Int, y: Int): Boolean {
        val a = (x / 3) * 3
        val b = (y / 3) * 3
        for (i in a..(a + 2)) {
            for (j in b..(b + 2)) {
                if (!(x == i && y == j) && (board[x][y] == board[i][j])) {
                    return false
                }
            }
        }
        return true
    }

    board.forEachIndexed { x, row ->
        row.forEachIndexed { y, char ->
            if (char != '.') {
                if (!rowCheck(x, y) || !colCheck(x, y) || !boxCheck(x, y)) {
                    return false
                }
            }
        }
    }
    return true
}

private fun main() {

}
