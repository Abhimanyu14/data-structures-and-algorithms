package leetcode.leetcode_253_meeting_rooms_ii

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/meeting-rooms-ii/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [List]
 * Algorithm -
 *
 * List methods - [sortedBy], list iterator
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 312 ms, faster than 80.36%
 * Memory Usage: 41.3 MB, less than 80.36%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
fun minMeetingRoomsUsingIterator(intervals: Array<IntArray>): Int {
    val sortedList = intervals.sortedBy { it[0] }
    val rooms = mutableListOf<IntArray>()
    var maxRooms = 0
    for (interval in sortedList) {
        val iterator = rooms.listIterator()
        while (iterator.hasNext()) {
            if (iterator.next()[1] <= interval[0]) {
                iterator.remove()
            }
        }
        rooms.add(interval)
        if (maxRooms < rooms.size) {
            maxRooms = rooms.size
        }
    }
    return maxRooms
}

/**
 * leetcode - https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 268 ms, faster than 86.61%
 * Memory Usage: 41.7 MB, less than 75.89%
 */
fun minMeetingRoomsUsingPriorityQueue(intervals: Array<IntArray>): Int {
    val sortedList = intervals.sortedBy { it[0] }
    val priorityQueue = PriorityQueue<Int>()
    var maxRooms = 0
    for (interval in sortedList) {
        while (priorityQueue.isNotEmpty() && priorityQueue.peek() < interval[0]) {
            priorityQueue.poll()
        }
        priorityQueue.offer(interval[1])
        if (maxRooms < priorityQueue.size) {
            maxRooms = priorityQueue.size
        }
    }
    return maxRooms
}

/**
 * leetcode - https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Using two sorted lists by splitting the intervals and two pointer
 *
 * Stats
 * Runtime: 434 ms, faster than 51.78
 * Memory Usage: 45.6 MB, less than 62.50%
 */
fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val startSortedList = intervals.map { it[0] }.sorted()
    val endSortedList = intervals.map { it[1] }.sorted()
    var rooms = 0
    var maxRooms = 0
    var startPointer = 0
    var endPointer = 0
    while (startPointer < intervals.size) {
        if (endSortedList[endPointer] <= startSortedList[startPointer]) {
            rooms--
            endPointer++
        } else {
            rooms++
            startPointer++
            if (maxRooms < rooms) {
                maxRooms = rooms
            }
        }
    }
    return maxRooms
}

private fun main() {

}
