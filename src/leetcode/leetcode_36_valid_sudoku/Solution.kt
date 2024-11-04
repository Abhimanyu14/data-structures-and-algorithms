package leetcode.leetcode_36_valid_sudoku

/**
 * leetcode - https://leetcode.com/problems/valid-sudoku/
 *
 * Using loops
 *
 * Stats
 * Runtime: 5 ms, faster than 75.00%
 * Memory Usage: 43.9 MB, less than 11.17%
 *
 * N = 9
 * Time - O(N * N)
 * Space - O(N)
 */
private     fun isValidSudoku(board: Array<CharArray>): Boolean {
    val set = mutableSetOf<Char>()
    repeat(9) { i ->
        set.clear()
        repeat(9) { j ->
            if (board[i][j] != '.') {
                if (set.contains(board[i][j])) {
                    return false
                }
                set.add(board[i][j])
            }
        }
    }
    repeat(9) { i ->
        set.clear()
        repeat(9) { j ->
            if (board[j][i] != '.') {
                if (set.contains(board[j][i])) {
                    return false
                }
                set.add(board[j][i])
            }
        }
    }
    repeat(3) { i ->
        repeat(3) { j ->
            set.clear()
            repeat(3) { row ->
                repeat(3) { col ->
                    if (board[3 * i + row][3 * j + col] != '.') {
                        if (set.contains(board[3 * i + row][3 * j + col])) {
                            return false
                        }
                        set.add(board[3 * i + row][3 * j + col])
                    }
                }
            }
        }
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/valid-sudoku/
 *
 * Using loops
 *
 * Stats
 * Runtime: 201 ms, faster than 48.50%
 * Memory Usage: 38.1 MB, less than 63.30%
 *
 * Time -
 * Space -
 */
private fun isValidSudokuUsingCellCheck(board: Array<CharArray>): Boolean {
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
