package leetcode.leet_700_to_799.leet_731_my_calendar_ii

import java.util.TreeMap



/**
 * leetcode - https://leetcode.com/problems/my-calendar-ii/?envType=daily-question&envId=2024-09-27
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
internal class MyCalendarTwo {
    private val bookingCount = TreeMap<Int, Int>()
    private val maxOverlappedBooking = 2

    fun book(start: Int, end: Int): Boolean {
        // Increase the booking count at 'start' and decrease at 'end'.
        bookingCount[start] = bookingCount.getOrDefault(start, 0) + 1
        bookingCount[end] = bookingCount.getOrDefault(end, 0) - 1

        var overlappedBooking = 0

        // Calculate the prefix sum of bookings.
        for ((_, value) in bookingCount) {
            overlappedBooking += value

            // If the number of overlaps exceeds the allowed limit, rollback and
            // return false.
            if (overlappedBooking > maxOverlappedBooking) {
                // Rollback changes.
                bookingCount[start] = bookingCount[start]!! - 1
                bookingCount[end] = bookingCount[end]!! + 1

                // Clean up if the count becomes zero to maintain the map clean.
                if (bookingCount[start] == 0) {
                    bookingCount.remove(start)
                }

                return false
            }
        }

        return true
    }
}

private fun main() {

}
