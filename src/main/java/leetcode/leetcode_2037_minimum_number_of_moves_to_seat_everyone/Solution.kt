package leetcode.leetcode_2037_minimum_number_of_moves_to_seat_everyone

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/?envType=daily-question&envId=2024-06-13
 *
 * Using sorting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 197 ms, faster than 68.42%
 * Memory Usage: 40.1 MB, less than 42.11%
 *
 * Time -
 * Space -
 */
private fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    var result = 0
    val sortedSeats = seats.sorted()
    val sortedStudents = students.sorted()
    for (i in seats.indices) {
        result += abs(sortedSeats[i] - sortedStudents[i])
    }
    return result
}

private fun main() {

}
