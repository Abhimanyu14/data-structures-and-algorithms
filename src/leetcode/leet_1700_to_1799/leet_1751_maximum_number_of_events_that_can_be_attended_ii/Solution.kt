package leetcode.leet_1700_to_1799.leet_1751_maximum_number_of_events_that_can_be_attended_ii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 *
 * TODO(Abhi) - To complete
 *
 * Using sorting - sortWith and compareBy to sort using multiple values
 *
 * Stats
 *
 */
private fun maxValue(events: Array<IntArray>, k: Int): Int {
    events.sortWith(compareBy({ it[0] }, { it[1] }))

    fun nextEvent(pos: Int): Int {
        var left = pos + 1
        var right = events.lastIndex
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (events[mid][0] > events[pos][1]) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun helper(pos: Int, updatedK: Int): Int {
        if (pos > events.lastIndex || updatedK == 0) {
            return 0
        }
        val selected = events[pos][2] + helper(nextEvent(pos), k - 1)
        val notSelected = helper(pos + 1, k)
        return max(selected, notSelected)
    }

    return helper(0, k)
}

private fun main() {

}
