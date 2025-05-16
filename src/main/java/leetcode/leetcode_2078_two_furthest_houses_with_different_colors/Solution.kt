package leetcode.leetcode_2078_two_furthest_houses_with_different_colors

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/two-furthest-houses-with-different-colors/description
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun maxDistance(colors: IntArray): Int {
    var index = 0
    while (colors[colors.lastIndex] == colors[index]) {
        index++
    }
    var result = colors.lastIndex - index
    index = colors.lastIndex
    while (colors[0] == colors[index]) {
        index--
    }
    result = max(result, index)
    return result
}

private fun main() {

}
