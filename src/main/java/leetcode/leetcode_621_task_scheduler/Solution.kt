package leetcode.leetcode_621_task_scheduler

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/task-scheduler/
 *
 * TODO(Abhi) - To revisit
 *
 * Using greedy
 *
 * Stats
 * Runtime: 241 ms, faster than 97.44%
 * Memory Usage: 39.5 MB, less than 69.23%
 */
private fun leastInterval(tasks: CharArray, n: Int): Int {
    // Counter array to store the frequency of each task
    val counter = IntArray(26)
    var maximum = 0
    var maxCount = 0

    // Traverse through tasks to calculate task frequencies
    tasks.forEach { task ->
        counter[task - 'A']++
        if (maximum == counter[task - 'A']) {
            maxCount++
        } else if (maximum < counter[task - 'A']) {
            maximum = counter[task - 'A']
            maxCount = 1
        }
    }

    // Calculate idle slots, available tasks, and idles needed
    val partCount = maximum - 1
    val partLength = n - (maxCount - 1)
    val emptySlots = partCount * partLength
    val availableTasks = tasks.size - maximum * maxCount
    val idles = max(0, emptySlots - availableTasks)

    return tasks.size + idles
}

private fun main() {

}
