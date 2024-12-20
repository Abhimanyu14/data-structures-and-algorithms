package leetcode.leetcode_119_pascals_triangle_ii

/**
 * leetcode - https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Data Structure -
 * Algorithm -
 *
 * Using loops
 * Pascal triangle
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 165 ms, faster than 17.91%
 * Memory Usage: 35.3 MB, less than 34.33%
 *
 * Time -
 * Space -
 */
private fun getRow(rowIndex: Int): List<Int> {
    var prev = mutableListOf(1)
    if (rowIndex == 0) {
        return prev
    }
    val current = mutableListOf<Int>()
    repeat(rowIndex) {
        current.clear()
        current.add(1)
        for (i in 1 until (it + 1)) {
            current.add(prev[i - 1] + prev[i])
        }
        current.add(1)
        prev = current.toMutableList()
    }
    return current
}

/**
 * leetcode - https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Using loops
 * Pascal triangle
 *
 * Stats
 * Runtime: 146 ms, faster than 66.42%
 * Memory Usage: 34.3 MB, less than 73.88%
 */
private fun getRowPascalTriangle(rowIndex: Int): List<Int> {
    val numRows = rowIndex + 1
    if (numRows == 0) {
        return emptyList()
    }
    val result = mutableListOf<List<Int>>()
    result.add(listOf(1))
    for (i in 1 until numRows) {
        val rowItem = mutableListOf<Int>()
        rowItem.add(1)
        for (j in 1 until i) {
            rowItem.add(result[i - 1][j - 1] + result[i - 1][j])
        }
        rowItem.add(1)
        result.add(rowItem)
    }
    return result[rowIndex]
}

private fun main() {

}
