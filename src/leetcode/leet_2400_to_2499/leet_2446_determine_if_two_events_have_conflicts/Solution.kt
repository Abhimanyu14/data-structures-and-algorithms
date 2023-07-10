package leetcode.leet_2400_to_2499.leet_2446_determine_if_two_events_have_conflicts

import kotlin.math.max
import kotlin.math.min

/**
 * Using substring, range and conditional operators
 *
 * leetcode - https://leetcode.com/problems/determine-if-two-events-have-conflict/
 *
 * Stats
 * Runtime: 150 ms, faster than 93.33%
 * Memory Usage: 33.6 MB, less than 100.00%
 */
private fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
    val event1Start = (event1[0].substring(0, 2).toInt()) * 60 + event1[0].substring(3, 5).toInt()
    val event1End = event1[1].substring(0, 2).toInt() * 60 + event1[1].substring(3, 5).toInt()

    val event2Start = event2[0].substring(0, 2).toInt() * 60 + event2[0].substring(3, 5).toInt()
    val event2End = event2[1].substring(0, 2).toInt() * 60 + event2[1].substring(3, 5).toInt()
    return max(event1Start, event2Start) > min(event1End, event2End)
    // return event2Start in event1Start..event1End || event1Start in event2Start..event2End
}

private fun main() {

}
