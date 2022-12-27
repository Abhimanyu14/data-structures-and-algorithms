package leetcode.leet_100_to_199.leet_135_candy

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/candy/
 * TODO-Abhi: To complete
 *
 * Using
 *
 * Stats
 *
 */
private fun count(n: Int): Int {
    return n * (n + 1) / 2
}

private fun candy(ratings: IntArray): Int {
    if (ratings.size <= 1) {
        return ratings.size
    }

    var candies = 0
    var up = 0
    var down = 0
    var oldSlope = 0
    for (i in 1 until ratings.size) {
        val newSlope = if (ratings[i] > ratings[i - 1]) {
            1
        } else if (ratings[i] < ratings[i - 1]) {
            -1
        } else {
            0
        }
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

private fun main() {
    println(candy(intArrayOf(1, 0, 2)))
}
