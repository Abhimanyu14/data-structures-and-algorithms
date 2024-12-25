package leetcode.leetcode_2280_minimum_lines_to_represent_a_line_chart

/**
 * leetcode - https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
 *
 * Data Structure - Array
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 75 ms, faster than 87.50%
 * Memory Usage: 80.8 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun minimumLines(stockPrices: Array<IntArray>): Int {
    if (stockPrices.size == 1) {
        return 0
    }
    val sortedStockPrices = stockPrices.sortedBy { it[0] }
    var currentDeltaX = sortedStockPrices[1][0] - sortedStockPrices[0][0]
    var currentDeltaY = sortedStockPrices[1][1] - sortedStockPrices[0][1]
    var result = 1
    for (i in 2..sortedStockPrices.lastIndex) {
        val newDeltaX = sortedStockPrices[i][0] - sortedStockPrices[i - 1][0]
        val newDeltaY = sortedStockPrices[i][1] - sortedStockPrices[i - 1][1]
        if (currentDeltaX * newDeltaY != newDeltaX * currentDeltaY) {
            result++
            currentDeltaX = newDeltaX
            currentDeltaY = newDeltaY
        }
    }
    return result
}

private fun main() {

}
