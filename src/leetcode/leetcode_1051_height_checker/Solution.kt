package leetcode.leetcode_1051_height_checker

/**
 * leetcode - https://leetcode.com/problems/height-checker/?envType=daily-question&envId=2024-06-10
 *
 * Using sorting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 178 ms, faster than 31.08%
 * Memory Usage: 37.5 MB, less than 33.78%
 *
 * Time -
 * Space -
 */
private fun heightChecker(heights: IntArray): Int {
    var result = 0
    val sorted = heights.sorted()
    for (i in heights.indices) {
        if (sorted[i] != heights[i]) {
            result++
        }
    }
    return result
}

private fun main() {

}
