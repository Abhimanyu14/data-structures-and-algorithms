package leetcode.leetcode_120_triangle

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/triangle?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 *
 * Data Structure - Array
 * Algorithm - Dynamic Programming
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 10 ms, faster than 52.59%
 * Memory Usage: 38.9 MB, less than 41.54%
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 */
private fun minimumTotal(triangle: List<List<Int>>): Int {
    val result = triangle.last().toIntArray()
    for (i in (triangle.lastIndex - 1) downTo 0) {
        for (j in 0..i) {
            result[j] = triangle[i][j] + min(result[j], result[j + 1])
        }
    }
    return result[0]
}

private fun main() {

}
