package leetcode.leet_0_to_99.leet_51_n_queens


/**
 * leetcode - https://leetcode.com/problems/n-queens/
 *
 * TODO(Abhi) - To revisit
 *
 * Using backtracking
 *
 * Stats
 * Runtime: 201 ms, faster than 79.49%
 * Memory Usage: 39.4 MB, less than 67.95%
 */
private fun solveNQueens(n: Int): List<List<String>> {
    val result: MutableList<List<String>> = ArrayList()

    // Making use of a helper function to get the solutions in the correct output format
    fun createBoard(state: Array<CharArray>): List<String> {
        val board: MutableList<String> = ArrayList()
        for (row in 0 until n) {
            val currentRow = String(state[row])
            board.add(currentRow)
        }
        return board
    }

    fun backtrack(
        row: Int,
        diagonals: MutableSet<Int>,
        antiDiagonals: MutableSet<Int>,
        cols: MutableSet<Int>,
        state: Array<CharArray>,
    ) {
        // Base case - N queens have been placed
        if (row == n) {
            result.add(createBoard(state))
            return
        }
        for (col in 0 until n) {
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
