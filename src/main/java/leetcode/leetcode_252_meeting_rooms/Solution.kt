package leetcode.leetcode_252_meeting_rooms

/**
 * leetcode - https://leetcode.com/problems/meeting-rooms/
 *
 * Data Structure - [Array]
 * Algorithm - Sorting and Iteration
 *
 * Array methods - [sortedBy]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 309 ms, faster than 83.05%
 * Memory Usage: 41.5 MB, less than 81.36%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
    val sortedList = intervals.sortedBy { it[0] }
    for (i in 0..<sortedList.lastIndex) {
        if (sortedList[i][1] > sortedList[i + 1][0]) {
            return false
        }
    }
    return true
}

private fun main() {

}
