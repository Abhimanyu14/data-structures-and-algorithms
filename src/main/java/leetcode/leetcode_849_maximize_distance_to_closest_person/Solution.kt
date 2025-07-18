package leetcode.leetcode_849_maximize_distance_to_closest_person

import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximize-distance-to-closest-person/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google
 */
private fun maxDistToClosest(seats: IntArray): Int {
    var result = 1
    var groupSize = 0
    var i = 0
    while (i <= seats.lastIndex && seats[i] == 0) {
        i++
    }
    result = max(result, i)
    while (i <= seats.lastIndex) {
        if (seats[i] == 1) {
            result = max(result, ceil(groupSize / 2.0).toInt())
            groupSize = 0
        } else {
            groupSize++
        }
        i++
    }
    result = max(result, groupSize)
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximize-distance-to-closest-person/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google
 */
private fun maxDistToClosestUsingArray(seats: IntArray): Int {
    var result = 1
    val left = IntArray(seats.size)
    val right = IntArray(seats.size)
    var current = -seats.size
    for (i in seats.indices) {
        left[i] = i - current
        if (seats[i] == 1) {
            current = i
        }
    }
    current = 2 * seats.size
    for (i in seats.lastIndex downTo 0) {
        right[i] = current - i
        if (seats[i] == 1) {
            current = i
        }
    }
    for (i in seats.indices) {
        if (seats[i] == 0) {
            result = max(result, min(left[i], right[i]))
        }
    }
    return result
}
