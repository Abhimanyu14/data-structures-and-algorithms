package leetcode.leetcode_1900_to_1999.leetcode_1986_minimum_number_of_work_sessions_to_finish_the_tasks

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 *
 * Using
 *
 * Stats
 *
 */
private fun minSessions(tasks: IntArray, sessionTime: Int): Int {
    val priorityQueue = PriorityQueue<Int> { a, b ->
        b - a
    }
    tasks.forEach {
        priorityQueue.offer(it)
    }
    var sessions = 1
    var currentSessionHours = 0
    while (priorityQueue.isNotEmpty()) {
        val currentTaskTime = priorityQueue.poll()
        currentSessionHours += currentTaskTime
        if (currentSessionHours > sessionTime) {
            currentSessionHours = currentTaskTime
            sessions++
        }
    }
    return sessions
}

private fun main() {

}
