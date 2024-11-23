package leetcode.leetcode_1260_shift_2d_grid

/**
 * leetcode - https://leetcode.com/problems/shift-2d-grid/
 *
 * Using Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 12 ms, faster than 50.00%
 * Memory Usage: 39.8 MB, less than 92.86%
 *
 * Time -
 * Space -
 */
private fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    val result = MutableList(grid.size) { MutableList(grid[0].size) { 0 } }
    fun getIndex(x: Int, y: Int): Pair<Int, Int> {
        val pos = ((x * grid[0].size + y) + k) % (grid.size * grid[0].size)
        val x1 = pos / grid[0].size
        val y1 = pos - (x1 * grid[0].size)
        return Pair(x1, y1)
    }
    grid.forEachIndexed { i, row ->
        row.forEachIndexed { j, num ->
            val point = getIndex(i, j)
            result[point.first][point.second] = num
        }
    }
    return result
}

private fun main() {

}
