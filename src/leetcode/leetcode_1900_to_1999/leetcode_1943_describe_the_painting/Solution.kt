package leetcode.leetcode_1900_to_1999.leetcode_1943_describe_the_painting

import java.util.TreeMap

/**
 * leetcode - https://leetcode.com/problems/describe-the-painting/
 *
 * Using line sweep
 * Reference - https://leetcode.com/problems/describe-the-painting/discuss/3887403/java-Line-Sweep
 *
 * Stats
 * Runtime: 972 ms, faster than 100.00%
 * Memory Usage: 66.2 MB, less than 100.00%
 */
private fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
    val map = TreeMap<Int, Long>()
    segments.forEach { (start, end, color) ->
        map[start] = map.getOrDefault(start, 0L) + color
        map[end] = map.getOrDefault(end, 0L) - color
    }

    val result = mutableListOf<List<Long>>()
    var sum = 0L
    var start = 0
    for ((key, value) in map) {
        if (start != key && sum != 0L) {
            result.add(listOf(start.toLong(), key.toLong(), sum))
        }
        sum += value
        start = key
    }
    return result
}

private fun main() {

}
