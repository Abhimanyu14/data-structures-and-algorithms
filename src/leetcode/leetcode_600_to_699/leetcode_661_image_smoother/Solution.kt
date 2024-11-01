package leetcode.leetcode_600_to_699.leetcode_661_image_smoother

import kotlin.math.floor

/**
 * leetcode - https://leetcode.com/problems/image-smoother/?envType=daily-question&envId=2023-12-19
 *
 * Using iteration
 *
 * Stats
 * Runtime: 505 ms, faster than 9.09%
 * Memory Usage: 51.2 MB, less than 9.09%
 */
private fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    fun getAdjacentIndices(row: Int, col: Int): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        if (row > 0) {
            result.add(Pair(row - 1, col))
            if (col > 0) {
                result.add(Pair(row - 1, col - 1))
            }
            if (col < img[0].lastIndex) {
                result.add(Pair(row - 1, col + 1))
            }
        }
        if (col > 0) {
            result.add(Pair(row, col - 1))
        }
        if (col < img[0].lastIndex) {
            result.add(Pair(row, col + 1))
        }
        if (row < img.lastIndex) {
            result.add(Pair(row + 1, col))
            if (col > 0) {
                result.add(Pair(row + 1, col - 1))
            }
            if (col < img[0].lastIndex) {
                result.add(Pair(row + 1, col + 1))
            }
        }
        return result
    }
    val result = Array(img.size) { IntArray(img[0].size) }
    img.forEachIndexed { row, items ->
        items.forEachIndexed { col, item ->
            var current = item
            val adjacent = getAdjacentIndices(row, col)
            adjacent.forEach {
                current += img[it.first][it.second]
            }
            result[row][col] = floor(current.toDouble() / (adjacent.size + 1)).toInt()
        }
    }
    return result
}

private fun main() {

}
