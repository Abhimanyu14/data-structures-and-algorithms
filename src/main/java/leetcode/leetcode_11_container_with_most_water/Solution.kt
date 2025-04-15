package leetcode.leetcode_11_container_with_most_water

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/container-with-most-water/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var result = 0
    while (left < right) {
        result = max(result, min(height[left], height[right]) * (right - left))
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/container-with-most-water/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Using loops
 *
 * Stats
 * Time limit exceeded
 */
private fun maxAreaNaive(height: IntArray): Int {
    var result = 0
    for (i in height.indices) {
        for (j in i + 1..<height.size) {
            result = maxOf(result, (j - i) * minOf(height[i], height[j]))
        }
    }
    return result
}

private fun main() {
    val input1 = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val input2 = intArrayOf(1, 1)
    val input3 = intArrayOf(4, 3, 2, 1, 4)
    val input4 = intArrayOf(1, 2, 1)
    println(maxArea(input1))
    println(maxArea(input2))
    println(maxArea(input3))
    println(maxArea(input4))
}
