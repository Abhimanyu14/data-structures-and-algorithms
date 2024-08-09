package leetcode.leet_800_to_899.leet_840_magic_squares_in_grid

/**
 * leetcode - https://leetcode.com/problems/magic-squares-in-grid/?envType=daily-question&envId=2024-08-09
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    fun isMagicSquare(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        // The sequences are each repeated twice to account for
        // the different possible starting points of the sequence
        // in the magic square
        val sequence = "2943816729438167"
        val sequenceReversed = "7618349276183492"

        val border = StringBuilder()
        // Flattened indices for bordering elements of 3x3 grid
        val borderIndices = intArrayOf(0, 1, 2, 5, 8, 7, 6, 3)
        for (i in borderIndices) {
            val num = grid[row + i / 3][col + (i % 3)]
            border.append(num)
        }

        val borderConverted = border.toString()

        // Make sure the sequence starts at one of the corners
        return (grid[row][col] % 2 == 0 &&
                (sequence.contains(borderConverted) ||
                        sequenceReversed.contains(borderConverted)) && grid[row + 1][col + 1] == 5
                )
    }

    var ans = 0
    val m = grid.size
    val n = grid[0].size
    var row = 0
    while (row + 2 < m) {
        var col = 0
        while (col + 2 < n) {
            if (isMagicSquare(grid, row, col)) {
                ans++
            }
            col++
        }
        row++
    }
    return ans
}

private fun main() {

}
