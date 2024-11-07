package leetcode.leetcode_729_my_calendar_i

import java.util.TreeMap

/**
 * leetcode - https://leetcode.com/problems/my-calendar-i/
 *
 * Using TreeMap
 *
 * Stats
 * Runtime: 392 ms, faster than 93.41%
 * Memory Usage: 52.2 MB, less than 86.81%
 */
private class MyCalendar {
    var bookings: TreeMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Boolean {
        val prev = bookings.floorKey(start)
        val next = bookings.ceilingKey(start)
        if ((prev == null || (bookings[prev] ?: 0) <= start) && (next == null || end <= next)) {
            bookings[start] = end
            return true
        }
        return false
    }
}

/**
 * leetcode - https://leetcode.com/problems/my-calendar-i/
 *
 * Using list - brute force simplified
 *
 * Stats
 * Runtime: 362 ms, faster than 98.90%
 * Memory Usage: 42.3 MB, less than 100.00%
 */
private class MyCalendarUsingList() {
    val bookings: MutableList<Pair<Int, Int>> = mutableListOf()

    fun book(start: Int, end: Int): Boolean {
        bookings.forEach { (first, last) ->
            if (start < last && end > first) {
                return false
            }
        }
        bookings.add(Pair(start, end))
        return true
    }
}

/**
 * leetcode - https://leetcode.com/problems/my-calendar-i/
 *
 * Using list - brute force
 *
 * Stats
 * Runtime: 446 ms, faster than 73.12%
 * Memory Usage: 52.7 MB, less than 74.19%
 */
private class MyCalendarBruteForce() {
    val bookings: MutableList<Pair<Int, Int>> = mutableListOf()

    fun book(start: Int, end: Int): Boolean {
        bookings.forEach {
            if (
                (start > it.first && start < it.second) ||
                (end > it.first && end < it.second) ||
                (start <= it.first && end >= it.second)
            ) {
                return false
            }
        }
        bookings.add(Pair(start, end))
        return true
    }
}

private fun main() {

}
