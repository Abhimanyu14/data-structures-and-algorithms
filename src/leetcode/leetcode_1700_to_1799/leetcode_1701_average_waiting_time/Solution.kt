package leetcode.leetcode_1700_to_1799.leetcode_1701_average_waiting_time

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/average-waiting-time/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 594 ms, faster than 40.00%
 * Memory Usage: 104.3 MB, less than 60.00%
 *
 * Time -
 * Space -
 */
private fun averageWaitingTime(customers: Array<IntArray>): Double {
    var currentTime = customers[0][0].toDouble()
    var waiting = 0.0
    customers.forEach { (arrival, time) ->
        currentTime = max(currentTime, arrival.toDouble()) + time
        waiting += (currentTime - arrival)
    }
    return waiting / customers.size
}

private fun main() {

}
