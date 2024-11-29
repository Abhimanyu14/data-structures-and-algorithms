package leetcode.leetcode_135_candy

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/candy/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - slope
 *
 * Stats
 * Runtime: 239 ms, faster than 56.48%
 * Memory Usage: 39.5 MB, less than 74.07%
 *
 * Time -
 * Space -
 */
private fun candy(ratings: IntArray): Int {
    if (ratings.size <= 1) {
        return ratings.size
    }

    fun count(n: Int): Int {
        return n * (n + 1) / 2
    }

    fun getSlope(prev: Int, current: Int): Int {
        return if (current > prev) {
            1
        } else if (current < prev) {
            -1
        } else {
            0
        }
    }

    var candies = 0
    var up = 0
    var down = 0
    var oldSlope = 0
    for (i in 1..ratings.lastIndex) {
        val newSlope = getSlope(ratings[i - 1], ratings[i])
        if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
            candies += count(up) + count(down) + max(up, down)
            up = 0
            down = 0
        }
        if (newSlope > 0) {
            up++
        } else if (newSlope < 0) {
            down++
        } else {
            candies++
        }
        oldSlope = newSlope
    }
    candies += count(up) + count(down) + max(up, down) + 1
    return candies
}

/**
 * leetcode - https://leetcode.com/problems/candy/
 *
 * Data Structure - Array
 * Algorithm - Slope
 *
 * Stats
 * Runtime: 24 ms, faster than 18.90%
 * Memory Usage: 41.3 MB, less than 14.08%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun candyUsingTwoArray(ratings: IntArray): Int {
    var result = 0
    val left = IntArray(ratings.size)
    val right = IntArray(ratings.size)
    left[0] = 1
    right[ratings.lastIndex] = 1
    for (i in 1..ratings.lastIndex) {
        left[i] = if (ratings[i] > ratings[i - 1]) {
            left[i - 1] + 1
        } else {
            1
        }
        right[ratings.lastIndex - i] = if (ratings[ratings.lastIndex - i] > ratings[ratings.lastIndex - i + 1]) {
            right[ratings.lastIndex - i + 1] + 1
        } else {
            1
        }
    }
    for (i in ratings.indices) {
        result += max(left[i], right[i])
    }
    return result
}

private fun main() {
    println(candy(intArrayOf(1, 0, 2)))
}
