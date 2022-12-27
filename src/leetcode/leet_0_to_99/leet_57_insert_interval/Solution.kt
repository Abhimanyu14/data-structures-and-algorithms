package leetcode.leet_0_to_99.leet_57_insert_interval

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/insert-interval/
 *
 * Using loop
 *
 * Stats
 * Runtime: 288 ms, faster than 77.34%
 * Memory Usage: 41 MB, less than 73.44%
 */
private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = intervals.toMutableList()
    var index = 0
    while (index < result.size && result[index][1] < newInterval[0]) {
        index++
    }
    result.add(index, newInterval)
    while (index < result.lastIndex && result[index][1] >= result[index + 1][0]) {
        result[index] = intArrayOf(
            min(result[index][0], result[index + 1][0]),
            max(result[index][1], result[index + 1][1]),
        )
        result.removeAt(index + 1)
    }
    return result.toTypedArray()
}

private fun main() {
    println(
        insert(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(6, 9),
            ),
            intArrayOf(2, 5)
        )
    )
    println(
        insert(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 5),
                intArrayOf(6, 7),
                intArrayOf(8, 10),
                intArrayOf(12, 16),
            ),
            intArrayOf(4, 8)
        )
    )
    println(
        insert(
            arrayOf(),
            intArrayOf(5, 7)
        )
    )
}
