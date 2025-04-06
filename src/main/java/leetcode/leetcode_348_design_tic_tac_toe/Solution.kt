package leetcode.leetcode_348_design_tic_tac_toe

/**
 * leetcode - https://leetcode.com/problems/design-tic-tac-toe
 * Premium Question
 *
 * Data Structure - [Array], [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class TicTacToe(val n: Int) {
    private val board = Array(n) { IntArray(n) }

    fun move(row: Int, col: Int, player: Int): Int {
        board[row][col] = player
        fun matchingRow(): Boolean {
            for (i in 0..<n) {
                if (board[row][i] != player) {
                    return false
                }
            }
            return true
        }
        fun matchingCol(): Boolean {
            for (i in 0..<n) {
                if (board[i][col] != player) {
                    return false
                }
            }
            return true
        }
        fun matchingDiagonal1(): Boolean {
            if (row != col) {
                return false
            }
            for (i in 0..<n) {
                if (board[i][i] != player) {
                    return false
                }
            }
            return true
        }
        fun matchingDiagonal2(): Boolean {
            if (row + col != n - 1) {
                return false
            }
            for (i in 0..<n) {
                if (board[i][n - i - 1] != player) {
                    return false
                }
            }
            return true
        }

        if (matchingRow() || matchingCol() || matchingDiagonal1() || matchingDiagonal2()) {
            return player
        }
        return 0
    }
}

private fun main() {

}
