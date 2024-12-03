package leetcode.leetcode_2187_minimum_time_to_complete_trips

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-time-to-complete-trips/
 *
 * Data Structure - NA
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 39 ms, faster than 80.00%
 * Memory Usage: 52.6 MB, less than 63.64%
 *
 * Time -
 * Space -
 */
private fun minimumTime(time: IntArray, totalTrips: Int): Long {
    fun canComplete(currentTime: Long): Boolean {
        var trips = 0L
        for (t in time) {
            trips += currentTime / t
            if (trips >= totalTrips) {
                return true
            }
        }
        return false
    }

    var left = 0L
    var right = 1_000_000_000_000L
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (canComplete(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

/**
 * leetcode - https://leetcode.com/problems/minimum-time-to-complete-trips/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Priority Queue
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun minimumTimeUsingPriorityQueue(time: IntArray, totalTrips: Int): Long {
    var result: Long = -1L
    val priorityQueue = PriorityQueue<Pair<Int, Long>> { a, b ->
        (a.second - b.second).toInt()
    }
    time.forEachIndexed { index, t ->
        priorityQueue.offer(Pair(index, t.toLong()))
    }
    repeat(totalTrips) {
        val (currentIndex, currentTime) = priorityQueue.poll()
        result = currentTime
        priorityQueue.offer(Pair(currentIndex, currentTime + time[currentIndex]))
    }
    return result
}

private fun main() {

}
