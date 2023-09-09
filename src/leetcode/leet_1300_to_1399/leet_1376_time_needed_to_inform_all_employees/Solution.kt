package leetcode.leet_1300_to_1399.leet_1376_time_needed_to_inform_all_employees

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * Using map
 *
 * Stats
 * Runtime: 742 ms, faster than 78.57%
 * Memory Usage: 65.7 MB, less than 21.43%
 */
private fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
    val managerMap = mutableMapOf<Int, MutableList<Int>>()
    manager.forEachIndexed { index, item ->
        managerMap.computeIfAbsent(item) {
            mutableListOf()
        }.add(index)
    }
    fun timeTaken(id: Int, time: Int): Int {
        if (!managerMap.keys.contains(id)) {
            return time
        }
        var maxValue = 0
        managerMap[id]?.forEach {
            maxValue = max(maxValue, timeTaken(it, time + informTime[id]))
        }
        return maxValue
    }
    return timeTaken(headID, 0)
}

private fun main() {
    println(numOfMinutes(6, 2, intArrayOf(2, 2, -1, 2, 2, 2), intArrayOf(0, 0, 1, 0, 0, 0)))
}
