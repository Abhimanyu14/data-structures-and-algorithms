package leetcode.leet_2100_to_2199.leet_2128_remove_all_ones_with_row_and_column_flips

/**
 * leetcode - https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 484 ms, faster than 83.33%
 * Memory Usage: 89.8 MB, less than 33.33%
 */
private fun removeOnes(grid: Array<IntArray>): Boolean {
    // Traverse first row
    for (i in 0..grid[0].lastIndex) {
        if (grid[0][i] == 1) {
            flipCol(grid, i)
        }
    }

    for (i in 1..grid.lastIndex) {
        for (j in 0..grid[0].lastIndex) {
            if (grid[i][j] == 1 && (j > 0 || !flipRowIfPossible(grid, i))) {
                return false
            }
        }
    }
    return true
}

private fun flipRowIfPossible(grid: Array<IntArray>, row: Int): Boolean {
    for (i in 0..grid[0].lastIndex) {
        if (grid[row][i] == 0) {
            return false
        } else {
            grid[row][i] = 0
        }
    }
    return true
}

private fun flipCol(grid: Array<IntArray>, col: Int) {
    fun flipBit(x: Int): Int {
        return if (x == 0) {
            1
        } else {
            0
        }
    }
    for (i in 0..grid.lastIndex) {
        grid[i][col] = flipBit(grid[i][col])
    }
}

// TODO-Abhi: Solution using row structure comparison
private fun main() {
    println(removeOnes(arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 0))))
    println(removeOnes(arrayOf(intArrayOf(1, 1, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))))
    println(removeOnes(arrayOf(intArrayOf(0))))
}
