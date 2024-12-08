package leetcode.leetcode_2054_two_best_non_overlapping_events

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/two-best-non-overlapping-events/?envType=daily-question&envId=2024-12-08
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Priority Queue and Arrays - [sortedBy]
 * Algorithm - Sorting and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 155 ms, faster than 50.00%
 * Memory Usage: 105.6 MB, less than 100.00%
 *
 * Time - O(N log(N))
 * Space - O(N)
 */
private fun maxTwoEvents(events: Array<IntArray>): Int {
    var result = Int.MIN_VALUE
    var maxSoFar = 0
    val sortedEvents = events.sortedBy {
        it[0]
    }
    val pq = PriorityQueue<IntArray> { a, b ->
        a[1] - b[1]
    }
    for (event in sortedEvents) {
        while (pq.isNotEmpty() && pq.first()[1] < event[0]) {
            maxSoFar = max(maxSoFar, pq.poll()[2])
        }
        pq.offer(event)
        result = max(result, maxSoFar + event[2])
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/two-best-non-overlapping-events/?envType=daily-question&envId=2024-12-08
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Arrays - [sortedBy]
 * Algorithm - Sorting and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^2)
 * Space - O(N)
 */
private fun maxTwoEventsUsingSortingAndIteration(events: Array<IntArray>): Int {
    var result = Int.MIN_VALUE
    val sortedEvents = events.sortedBy { it[0] }
    var currentSum: Int
    for (firstEventIndex in sortedEvents.indices) {
        currentSum = 0
        for (secondEventIndex in (firstEventIndex + 1)..sortedEvents.lastIndex) {
            if (sortedEvents[firstEventIndex][1] < sortedEvents[secondEventIndex][0]) {
                currentSum = max(currentSum, sortedEvents[secondEventIndex][2])
            }
        }
        result = max(result, currentSum + sortedEvents[firstEventIndex][2])
    }
    return result
}

private fun main() {

}
