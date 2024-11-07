package leetcode.leetcode_1751_maximum_number_of_events_that_can_be_attended_ii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 *
 * Using sorting - sortWith and compareBy to sort using multiple values, binary search and memoization
 *
 * Stats
 * Runtime: 1696 ms, faster than 100.00%
 * Memory Usage: 366.5 MB, less than 100.00%
 *
 * Time - O(N * K * logN)
 * Space = O(N * K)
 */
private fun maxValue(events: Array<IntArray>, k: Int): Int {
    events.sortWith(compareBy({ it[0] }, { it[1] }))
    val memo: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

    fun nextEvent(pos: Int): Int {
        var left = pos + 1
        var right = events.size
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
        memo[Pair(pos, updatedK)]?.let {
            return it
        }

        if (pos > events.lastIndex || updatedK == 0) {
            return 0
        }
        val selected = events[pos][2] + helper(nextEvent(pos), updatedK - 1)
        val notSelected = helper(pos + 1, updatedK)
        memo[Pair(pos, updatedK)] = max(selected, notSelected)
        memo.getOrDefault(Pair(pos, updatedK), 0).let {
            return it
        }
    }

    return helper(0, k)
}

private fun main() {

}
