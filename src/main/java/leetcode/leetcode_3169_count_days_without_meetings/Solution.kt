package leetcode.leetcode_3169_count_days_without_meetings

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/count-days-without-meetings/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Array], [List]
 * Algorithm - Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Google
 */
private fun countDays(days: Int, meetings: Array<IntArray>): Int {
    var result = 0
    val sortedMeetings = meetings.sortedBy { it[0] }
    result += sortedMeetings[0][0] - 1
    var index = 0
    var currentEnd = sortedMeetings[0][1]
    while (index < sortedMeetings.lastIndex) {
        if (sortedMeetings[index + 1][0] > currentEnd + 1) {
            result += sortedMeetings[index + 1][0] - currentEnd - 1
        }
        currentEnd = max(currentEnd, sortedMeetings[index + 1][1])
        index++
    }
    result += days - currentEnd
    return result
}

private fun main() {

}
