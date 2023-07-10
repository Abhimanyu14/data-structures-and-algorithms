package leetcode.leet_1800_to_1899.leet_1834_single_threaded_cpu

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/single-threaded-cpu/
 *
 * Using priority queue and sorting
 *
 * Stats
 * Runtime: 1499 ms, faster than 50.00%
 * Memory Usage: 108.8 MB, less than 66.67%
 */
fun getOrder(tasks: Array<IntArray>): IntArray {
    val priorityQueue = PriorityQueue<Triple<Int, Int, Int>> { a, b ->
        if (a.second == b.second) {
            a.third - b.third
        } else {
            a.second - b.second
        }
    }
    val mappedTasks = tasks.mapIndexed { index, task ->
        Triple(task[0], task[1], index)
    }.sortedBy {
        it.first
    }
    val result = IntArray(tasks.size)
    var currTime: Long = 0
    var taskIndex = 0
    var ansIndex = 0
    while (taskIndex < tasks.size || !priorityQueue.isEmpty()) {
        if (priorityQueue.isEmpty() && currTime < mappedTasks[taskIndex].first) {
            currTime = mappedTasks[taskIndex].first.toLong()
        }
        while (taskIndex < tasks.size && mappedTasks[taskIndex].first <= currTime) {
            priorityQueue.offer(mappedTasks[taskIndex])
            taskIndex++
        }
        val currentTask = priorityQueue.poll()
        currTime += currentTask.second.toLong()
        result[ansIndex++] = currentTask.third
    }
    return result
}

private fun main() {
    println(
        getOrder(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 4),
                intArrayOf(3, 2),
                intArrayOf(4, 1),
            )
        ).joinToString(", ")
    )
}
