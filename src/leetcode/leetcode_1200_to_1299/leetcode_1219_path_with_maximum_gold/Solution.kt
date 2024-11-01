package leetcode.leetcode_1200_to_1299.leetcode_1219_path_with_maximum_gold

import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/path-with-maximum-gold/?envType=daily-question&envId=2024-05-14
 *
 * TODO(Abhi) - To revisit
 *
 * Using BFS and backtracking
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 2252 ms, faster than 12.50%
 * Memory Usage: 102.9 MB, less than 12.50%
 *
 * Time -
 * Space -
 */
private fun getMaximumGold(grid: Array<IntArray>): Int {
    val directions: IntArray = intArrayOf(0, 1, 0, -1, 0)
    var result = 0
    val totalGold = grid.sumOf { it.sum() }

    fun bfsBacktrack(row: Int, col: Int): Int {
        val queue = ArrayDeque<Pair<IntArray, Set<String>>>()
        val visited: MutableSet<String> = HashSet()
        var maxGold = 0
        visited.add("$row,$col")
        queue.addLast(Pair(intArrayOf(row, col, grid[row][col]), visited))

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val currRow: Int = current.first[0]
            val currCol: Int = current.first[1]
            val currGold: Int = current.first[2]
            val currVis: MutableSet<String> = current.second.toMutableSet()
            maxGold = max(maxGold.toDouble(), currGold.toDouble()).toInt()

            // Search for gold in each of the 4 neighbor cells
            for (direction in 0..3) {
                val nextRow = currRow + directions[direction]
                val nextCol = currCol + directions[direction + 1]

                // If the next cell is in the matrix, has gold,
                // and has not been visited, add it to the queue
                if (nextRow in grid.indices && nextCol >= 0 && nextCol < grid[0].size && grid[nextRow][nextCol] != 0 &&
                    !currVis.contains("$nextRow,$nextCol")
                ) {
                    currVis.add("$nextRow,$nextCol")
                    val copyVis: Set<String> = HashSet(currVis)
                    queue.addLast(Pair(intArrayOf(nextRow, nextCol, currGold + grid[nextRow][nextCol]), copyVis))
                    currVis.remove("$nextRow,$nextCol")
                }
            }
        }
        return maxGold
    }

    grid.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, item ->
            if (item != 0) {
                result = max(result, bfsBacktrack(rowIndex, colIndex))
                if (result == totalGold) {
                    return totalGold
                }
            }
        }
    }
    return result
}

private fun main() {

}
