package leetcode.leet_1800_to_1899.leet_1845_seat_reservation_manager

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/seat-reservation-manager/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 730 ms, faster than 72.73%
 * Memory Usage: 95.1 MB, less than 63.64%
 */
private class SeatManager(n: Int) {
    val availableSeats = PriorityQueue<Int>()
    var highest = 1

    fun reserve(): Int {
        if (availableSeats.isNotEmpty()) {
            return availableSeats.poll()
        }
        highest++
        return highest - 1
    }

    fun unreserve(seatNumber: Int) {
        availableSeats.offer(seatNumber)
    }
}

/**
 * leetcode - https://leetcode.com/problems/seat-reservation-manager/
 *
 * Using list
 *
 * Stats
 * Runtime: 1501 ms, faster than 9.09%
 * Memory Usage: 95.2 MB, less than 63.64%
 */
private class SeatManagerUsingList(n: Int) {
    private val list = MutableList(n) { false }
    private var smallest = -1

    fun reserve(): Int {
        smallest++
        while (list[smallest]) {
            smallest++
        }
        list[smallest] = true
        return smallest + 1
    }

    fun unreserve(seatNumber: Int) {
        list[seatNumber - 1] = false
        if (seatNumber - 1 <= smallest) {
            smallest = seatNumber - 2
        }
    }
}

private fun main() {

}
