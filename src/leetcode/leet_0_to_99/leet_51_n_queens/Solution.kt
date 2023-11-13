package leetcode.leet_0_to_99.leet_51_n_queens

/**
 * leetcode - https://leetcode.com/problems/n-queens/
 *
 * TODO(Abhi) - To complete
 *
 * Using backtracking
 *
 * Stats
 *
 */
private fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val stack = ArrayDeque<Pair<Int, Int>>()
    val board = List(n) {
        List(n) {
            '.'
        }.toMutableList()
    }.toMutableList()

    fun canPlaceQueen(x: Int, y: Int): Boolean {
        for (i in 0..n) {
            if ((board[i][y] == 'Q') || (board[x][i] == 'Q')) {
                return false
            }
        }
        var currX = x - 1
        var currY = y - 1
        while (currX > 0 && currY > 0) {
            if (board[currX][currY] == 'Q') {
                return false
            }
            currX--
            currY--
        }
        currX = x + 1
        currY = y + 1
        while (currX < n && currY < n) {
            if (board[currX][currY] == 'Q') {
                return false
            }
            currX++
            currY++
        }
        currX = x - 1
        currY = y + 1
        while (currX > 0 && currY < n) {
            if (board[currX][currY] == 'Q') {
                return false
            }
            currX--
            currY++
        }
        currX = x + 1
        currY = y - 1
        while (currX < n && currY > 0) {
            if (board[currX][currY] == 'Q') {
                return false
            }
            currX++
            currY--
        }

        return true
    }



    repeat(n) { i ->
        for (j in 0 until n) {
            if (canPlaceQueen(i, j)) {
                board[i][j] = 'Q'
                stack.addLast(Pair(i, j))
            }
        }
    }
    return result
}

private fun main() {

}
