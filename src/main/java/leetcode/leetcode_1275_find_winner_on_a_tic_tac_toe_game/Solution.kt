package leetcode.leetcode_1275_find_winner_on_a_tic_tac_toe_game

/**
 * leetcode - https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun tictactoe(moves: Array<IntArray>): String {
    val board = Array(3) { CharArray(3) { '.' } }
    fun findWinner(): Char? {
        for (i in 0..2) {
            if (
                (board[i][0] == 'A' && board[i][1] == 'A' && board[i][2] == 'A') ||
                (board[0][i] == 'A' && board[1][i] == 'A' && board[2][i] == 'A')
            ) {
                return 'A'
            }
            if (
                (board[i][0] == 'B' && board[i][1] == 'B' && board[i][2] == 'B') ||
                (board[0][i] == 'B' && board[1][i] == 'B' && board[2][i] == 'B')
            ) {
                return 'B'
            }
        }
        if (
            (board[0][0] == 'A' && board[1][1] == 'A' && board[2][2] == 'A') ||
            (board[0][2] == 'A' && board[1][1] == 'A' && board[2][0] == 'A')
        ) {
            return 'A'
        }
        if (
            (board[0][0] == 'B' && board[1][1] == 'B' && board[2][2] == 'B') ||
            (board[0][2] == 'B' && board[1][1] == 'B' && board[2][0] == 'B')
        ) {
            return 'B'
        }
        return null
    }
    for (i in moves.indices) {
        if (i % 2 == 0) {
            board[moves[i][0]][moves[i][1]] = 'A'
        } else {
            board[moves[i][0]][moves[i][1]] = 'B'
        }
        findWinner()?.let {
            return "$it"
        }
    }
    return if (moves.size == 9) {
        "Draw"
    } else {
        "Pending"
    }
}

private fun main() {

}
