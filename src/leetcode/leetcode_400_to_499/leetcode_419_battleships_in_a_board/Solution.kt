package leetcode.leetcode_400_to_499.leetcode_419_battleships_in_a_board

/**
 * leetcode - https://leetcode.com/problems/battleships-in-a-board/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 198 ms, faster than 81.25%
 * Memory Usage: 42.1 MB, less than 29.17%
 */
private fun countBattleships(board: Array<CharArray>): Int {
    var count = 0
    var temp: Int
    for (i in 0..board.lastIndex) {
        for (j in 0..board[0].lastIndex) {
            if (board[i][j] == 'X') {
                count++
                if (j + 1 <= board[0].lastIndex && board[i][j + 1] == 'X') {
                    temp = j + 1
                    while (temp <= board[0].lastIndex && board[i][temp] == 'X') {
                        board[i][temp] = '.'
                        temp++
                    }
                } else {
                    temp = i + 1
                    while (temp <= board.lastIndex && board[temp][j] == 'X') {
                        board[temp][j] = '.'
                        temp++
                    }
                }
            }
        }
    }
    return count
}

private fun main() {

}
