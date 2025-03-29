package leetcode.leetcode_1762_buildings_with_an_ocean_view

/**
 * leetcode - https://leetcode.com/problems/buildings-with-an-ocean-view/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - [List]
 * Algorithm - Iteration
 *
 * Using [reversed], [toIntArray]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun findBuildings(heights: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var current = 0
    for (i in heights.lastIndex downTo 0) {
        if (heights[i] > current) {
            current = heights[i]
            result.add(i)
        }
    }
    return result.reversed().toIntArray()
}

private fun main() {

}
