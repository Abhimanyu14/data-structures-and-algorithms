package leetcode.leetcode_2895_minimum_processing_time

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-processing-time/
 *
 * Using sorting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 109 ms, faster than 100.00%
 * Memory Usage: 66 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {
    val sortedTasks = tasks.sortedDescending()
    val sortedProcessorTime = processorTime.sorted()
    var result = sortedProcessorTime[0] + sortedTasks[0]
    for (i in 1..<(sortedProcessorTime.size / 4)) {
        result = max(result, sortedProcessorTime[i] + sortedTasks[4 * i])
    }
    return result
}

private fun main() {

}
