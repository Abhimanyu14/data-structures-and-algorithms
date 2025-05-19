package leetcode.leetcode_999_available_captures_for_rook

/**
 * leetcode - https://leetcode.com/problems/available-captures-for-rook/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N*N)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun numRookCaptures(board: Array<CharArray>): Int {
    var result = 0
    var x = 0
    var y = 0
    var rookFound = false
    while (x <= board.lastIndex) {
        y = 0
        while (y <= board[0].lastIndex) {
            if (board[x][y] == 'R') {
                rookFound = true
                break
            }
            y++
        }
        if (rookFound) {
            break
        }
        x++
    }

    for (i in (x - 1) downTo 0) {
        if (board[i][y] != '.') {
            if (board[i][y] == 'p') {
                result++
            }
            break
        }
    }
    for (i in (y - 1) downTo 0) {
        if (board[x][i] != '.') {
            if (board[x][i] == 'p') {
                result++
            }
            break
        }
    }
    for (i in (x + 1)..board.lastIndex) {
        if (board[i][y] != '.') {
            if (board[i][y] == 'p') {
                result++
            }
            break
        }
    }
    for (i in (y + 1)..board[0].lastIndex) {
        if (board[x][i] != '.') {
            if (board[x][i] == 'p') {
                result++
            }
            break
        }
    }
    return result
}

private fun main() {

}
