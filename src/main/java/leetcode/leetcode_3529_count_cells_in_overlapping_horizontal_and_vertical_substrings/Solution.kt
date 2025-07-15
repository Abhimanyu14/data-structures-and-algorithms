package leetcode.leetcode_3529_count_cells_in_overlapping_horizontal_and_vertical_substrings

/**
 * leetcode - https://leetcode.com/problems/count-cells-in-overlapping-horizontal-and-vertical-substrings/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun countCells(grid: Array<CharArray>, pattern: String): Int {
    val horizontalCells = mutableSetOf<Pair<Int, Int>>()
    val verticalCells = mutableSetOf<Pair<Int, Int>>()
    fun isHorizontalMatch(x: Int, y: Int) {
        var currentX = x
        var currentY = y
        val cells = mutableSetOf<Pair<Int, Int>>()
        var index = 0
        while (index <= pattern.lastIndex) {
            if (pattern[index] != grid[currentX][currentY]) {
                return
            }
            cells.add(Pair(currentX, currentY))
            currentY++
            if (currentY > grid[0].lastIndex) {
                currentY = 0
                currentX++
                if (currentX > grid.lastIndex) {
                    return
                }
            }
            index++
        }
        horizontalCells.addAll(cells)
    }

    fun isVerticalMatch(x: Int, y: Int) {
        var currentX = x
        var currentY = y
        val cells = mutableSetOf<Pair<Int, Int>>()
        var index = 0
        while (index <= pattern.lastIndex) {
            if (pattern[index] != grid[currentX][currentY]) {
                return
            }
            cells.add(Pair(currentX, currentY))
            currentX++
            if (currentX > grid.lastIndex) {
                currentX = 0
                currentY++
                if (currentY > grid[0].lastIndex) {
                    return
                }
            }
            index++
        }
        verticalCells.addAll(cells)
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == pattern[0]) {
                isHorizontalMatch(i, j)
                isVerticalMatch(i, j)
            }
        }
    }
    return (horizontalCells intersect verticalCells).size
}

private fun main() {

}
