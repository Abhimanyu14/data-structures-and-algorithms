package leetcode.leetcode_118_pascals_triangle

/**
 * leetcode - https://leetcode.com/problems/pascals-triangle/
 * https://leetcode.com/problems/pascals-triangle/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
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
 * Runtime: 160 ms, faster than 97.00%
 * Memory Usage: 35.1 MB, less than 63.52%
 *
 * Time -
 * Space -
 */
private fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (numRows == 0) {
        return result
    }
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
    return result
}

private fun main() {
    val output1 = listOf(
        listOf(1),
        listOf(1, 1),
        listOf(1, 2, 1),
        listOf(1, 3, 3, 1),
        listOf(1, 4, 6, 4, 1),
    )
    println(generate(5) == output1)
}
