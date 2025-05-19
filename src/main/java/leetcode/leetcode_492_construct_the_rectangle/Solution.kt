package leetcode.leetcode_492_construct_the_rectangle

import kotlin.math.sqrt

/**
 * leetcode - https://leetcode.com/problems/construct-the-rectangle/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Na
 * Algorithm - Linear Search and Maths
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(area)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun constructRectangle(area: Int): IntArray {
    var current = sqrt(area.toDouble()).toInt()
    while (area % current != 0) {
        current--
    }
    return intArrayOf(area / current, current)
}

private fun main() {

}
