package leetcode.leetcode_419_battleships_in_a_board

/**
 * leetcode -  https://leetcode.com/problems/battleships-in-a-board/
 *
 * Data Structure -
 * Algorithm - DFS
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
private fun countBattleships(board: Array<CharArray>): Int {
    var result = 0
    val visited = Array(board.size) { BooleanArray(board[0].size) }
    fun dfs(x: Int, y: Int) {
        visited[x][y] = true
        if (x > 0 && !visited[x - 1][y] && board[x - 1][y] == 'X') {
            dfs(x - 1, y)
        }
        if (x < board.lastIndex && !visited[x + 1][y] && board[x + 1][y] == 'X') {
            dfs(x + 1, y)
        }
        if (y > 0 && !visited[x][y - 1] && board[x][y - 1] == 'X') {
            dfs(x, y - 1)
        }
        if (y < board[0].lastIndex && !visited[x][y + 1] && board[x][y + 1] == 'X') {
            dfs(x, y + 1)
        }
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'X' && !visited[i][j]) {
                result++
                dfs(i, j)
            }
        }
    }
    return result
}

private fun countBattleshipsUsingBruteForce(board: Array<CharArray>): Int {
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
