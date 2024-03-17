package leetcode.leet_0_to_99.leet_57_insert_interval

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/insert-interval/
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Stats
 * Runtime: 241 ms, faster than 68.42%
 * Memory Usage: 40.7 MB, less than 26.87%
 */
private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    if (intervals.isEmpty()) {
        return arrayOf(newInterval)
    }

    var left = 0
    var right = intervals.size

    /**
     * Binary search to find last interval which starts before the given [newInterval]
     */
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (intervals[mid][0] >= newInterval[0]) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    val result = mutableListOf<IntArray>()
    for (i in 0..<left) {
        result.add(intervals[i])
    }

    fun insertInterval(interval: IntArray) {
        if (result.isEmpty() || result.last()[1] < interval[0]) {
            result.add(interval)
        } else {
            result.last()[1] = max(result.last()[1], interval[1])
        }
    }

    insertInterval(newInterval)
    for (i in left..intervals.lastIndex) {
        insertInterval(intervals[i])
    }

    return result.toTypedArray<IntArray>()
}

/**
 * leetcode - https://leetcode.com/problems/insert-interval/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 265 ms, faster than 85.11%
 * Memory Usage: 40.1 MB, less than 69.50%
 */
private fun insertOld(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    fun doesIntervalsOverlap(a: IntArray, b: IntArray): Boolean {
        return min(a[1], b[1]) - max(a[0], b[0]) >= 0
    }

    fun mergeIntervals(a: IntArray, b: IntArray): IntArray {
        return intArrayOf(min(a[0], b[0]), max(a[1], b[1]))
    }

    fun upperBound(intervals: Array<IntArray>, newIntervalStart: Int): Int {
        if (intervals.isEmpty()) {
            return 0
        }
        var start = 0
        var end = intervals.lastIndex
        var pos = intervals.size
        while (start <= end) {
            val mid = start + ((end - start) / 2)
            if (intervals[mid][0] > newIntervalStart) {
                pos = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return pos
    }

    fun insertInterval(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val list = intervals.toMutableList()
        val index = upperBound(intervals, newInterval[0])
        list.add(index, newInterval)
        return list.toTypedArray()
    }

    val intervalsAfterInsertion = insertInterval(intervals, newInterval)
    val result: MutableList<IntArray> = mutableListOf()
    var i = 0
    while (i < intervalsAfterInsertion.size) {
        var currInterval = intervalsAfterInsertion[i]
        while (i < intervalsAfterInsertion.size && doesIntervalsOverlap(currInterval, intervalsAfterInsertion[i])) {
            currInterval = mergeIntervals(currInterval, intervalsAfterInsertion[i])
            i++
        }
        i--
        result.add(currInterval)
        i++
    }
    return result.toTypedArray()
}

/**
 * leetcode - https://leetcode.com/problems/insert-interval/
 *
 * Using linear search
 *
 * Stats
 * Runtime: 288 ms, faster than 77.34%
 * Memory Usage: 41 MB, less than 73.44%
 */
private fun insertUsingLinearSearch(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
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
