package leetcode.leet_1200_to_1299.leet_1289_minimum_falling_path_sum_ii

/**
 * leetcode - https://leetcode.com/problems/minimum-falling-path-sum-ii/?envType=daily-question&envId=2024-04-26
 *
 * TODO(Abhi) - To revisit
 *
 * Using DP
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 236 ms, faster than 100.00%
 * Memory Usage: 41.4 MB, less than 75.00%
 *
 * Time -
 * Space -
 */
private fun minFallingPathSum(grid: Array<IntArray>): Int {
    // Minimum and Second Minimum Column Index
    var nextMin1C = -1
    var nextMin2C = -1

    // Minimum and Second Minimum Value
    var nextMin1 = -1
    var nextMin2 = -1

    // Find the minimum and second minimum from the last row
    for (col in grid.indices) {
        if (nextMin1 == -1 || grid[grid.size - 1][col] <= nextMin1) {
            nextMin2 = nextMin1
            nextMin2C = nextMin1C
            nextMin1 = grid[grid.size - 1][col]
            nextMin1C = col
        } else if (nextMin2 == -1 || grid[grid.size - 1][col] <= nextMin2) {
            nextMin2 = grid[grid.size - 1][col]
            nextMin2C = col
        }
    }

    // Fill the recursive cases
    for (row in grid.size - 2 downTo 0) {
        // Minimum and Second Minimum Column Index of the current row
        var min1C = -1
        var min2C = -1

        // Minimum and Second Minimum Value of current row
        var min1 = -1
        var min2 = -1

        for (col in grid.indices) {
            // Select minimum from valid cells of the next row
            val value = if (col != nextMin1C) {
                grid[row][col] + nextMin1
            } else {
                grid[row][col] + nextMin2
            }

            // Save minimum and second minimum
            if (min1 == -1 || value <= min1) {
                min2 = min1
                min2C = min1C
                min1 = value
                min1C = col
            } else if (min2 == -1 || value <= min2) {
                min2 = value
                min2C = col
            }
        }

        // Change of row. Update nextMin1C, nextMin2C, nextMin1, nextMin2
        nextMin1C = min1C
        nextMin2C = min2C
        nextMin1 = min1
        nextMin2 = min2
    }


    // Return the minimum from the first row
    return nextMin1
}

private fun main() {

}
