package leetcode.leetcode_52_n_queens_ii

/**
 * leetcode - https://leetcode.com/problems/n-queens-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using backtracking
 *
 * Stats
 * Runtime: 153 ms, faster than 47.17%
 * Memory Usage: 35 MB, less than 62.26%
 */
private fun totalNQueens(n: Int): Int {
    var result = 0

    fun backtrack(
        row: Int,
        diagonals: MutableSet<Int>,
        antiDiagonals: MutableSet<Int>,
        cols: MutableSet<Int>,
        state: Array<CharArray>,
    ) {
        // Base case - N queens have been placed
        if (row == n) {
            result++
            return
        }
        for (col in 0..<n) {
            val currDiagonal = row - col
            val currAntiDiagonal = row + col
            // If the queen is not placeable
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue
            }

            // "Add" the queen to the board
            cols.add(col)
            diagonals.add(currDiagonal)
            antiDiagonals.add(currAntiDiagonal)
            state[row][col] = 'Q'

            // Move on to the next row with the updated board state
            backtrack(row + 1, diagonals, antiDiagonals, cols, state)

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col)
            diagonals.remove(currDiagonal)
            antiDiagonals.remove(currAntiDiagonal)
            state[row][col] = '.'
        }
    }

    val emptyBoard = Array(n) { CharArray(n) { '.' } }
    backtrack(0, mutableSetOf(), mutableSetOf(), mutableSetOf(), emptyBoard)
    return result
}

private fun main() {

}
