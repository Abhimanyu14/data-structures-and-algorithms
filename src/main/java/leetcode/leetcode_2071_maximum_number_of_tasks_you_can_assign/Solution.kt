package leetcode.leetcode_2071_maximum_number_of_tasks_you_can_assign

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/description/?envType=daily-question&envId=2025-05-01
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Wrong Answer
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
    val sortedTasks = tasks.sorted()
    val sortedWorkers = workers.sorted()

    fun canComplete(k: Int): Boolean {
        var remainingPills = pills
        var workersStartIndex = sortedWorkers.size - k
        var workersEndIndex = sortedWorkers.lastIndex
        for (i in (k - 1) downTo 0) {
            if (sortedWorkers[workersEndIndex] >= sortedTasks[i]) {
                workersEndIndex--
            } else if (remainingPills > 0 && sortedWorkers[workersStartIndex] + strength >= sortedTasks[i]) {
                remainingPills--
                workersStartIndex++
            } else {
                return false
            }
        }
        return true
    }

    var left = 1
    var right = min(tasks.size, workers.size) + 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (!canComplete(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left - 1
}

private fun main() {

}
