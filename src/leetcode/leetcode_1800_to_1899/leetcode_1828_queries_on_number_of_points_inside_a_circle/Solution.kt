package leetcode.leetcode_1800_to_1899.leetcode_1828_queries_on_number_of_points_inside_a_circle

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * leetcode - https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    var count: Int
    queries.forEachIndexed { index, ints ->
        count = 0
        points.forEach {
            if (sqrt((ints[0] - it[0]).toDouble().pow(2.0) + (ints[1] - it[1]).toDouble().pow(2.0)) <= ints[2]) {
                count++
            }
        }
        result[index] = count
    }
    return result
}

private fun main() {
    val points1 = arrayOf(intArrayOf(1, 3), intArrayOf(3, 3), intArrayOf(5, 3), intArrayOf(2, 2))
    val queries1 = arrayOf(intArrayOf(2, 3, 1), intArrayOf(4, 3, 1), intArrayOf(1, 1, 2))
    println(countPoints(points1, queries1).joinToString(" "))

    val points2 = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(5, 5))
    val queries2 = arrayOf(intArrayOf(1, 2, 2), intArrayOf(2, 2, 2), intArrayOf(4, 3, 2), intArrayOf(4, 3, 3))
    println(countPoints(points2, queries2).joinToString(" "))
}
