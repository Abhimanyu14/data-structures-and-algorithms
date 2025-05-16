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
 * Time - O(1)
 * Space - O(4 * N)
 *
 * Companies - Meta
 */
private class TicTacToe(private val n: Int) {
    private val rows = Array(n) { IntArray(2) }
    private val cols = Array(n) { IntArray(2) }
    private val diagonal1 = IntArray(2)
    private val diagonal2 = IntArray(2)

    fun move(row: Int, col: Int, player: Int): Int {
        rows[row][player - 1]++
        if (rows[row][player - 1] == n) {
            return player
        }

        cols[col][player - 1]++
        if (cols[col][player - 1] == n) {
            return player
        }

        if (row == col) {
            diagonal1[player - 1]++
            if (diagonal1[player - 1] == n) {
                return player
            }
        }

        if (row + col == n - 1) {
            diagonal2[player - 1]++
            if (diagonal2[player - 1] == n) {
                return player
            }
        }

        return 0
    }
}

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
 * Time - O(4 * N)
 * Space - O(N * N)
 *
 * Companies - Meta
 */
private class TicTacToeWithBoard(val n: Int) {
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
