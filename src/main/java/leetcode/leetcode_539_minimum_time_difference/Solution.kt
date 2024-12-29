package leetcode.leetcode_539_minimum_time_difference

import kotlin.math.abs

fun findMinDifference(timePoints: List<String>): Int {
    val sorted = timePoints.map {
        it.substring(0, 2).toInt() * 60 + it.substring(3, 5).toInt()
    }.sorted()
    var result = abs(sorted[0] - sorted[1])
    for (i in 2..<sorted.size) {
        result = minOf(result, abs(sorted[i] - sorted[i - 1]))
    }
    result = minOf(result, 60 * 24 - (sorted.last() - sorted.first()))
    return result
}

private fun main() {
    println(findMinDifference(listOf("23:59", "00:00")))
}
