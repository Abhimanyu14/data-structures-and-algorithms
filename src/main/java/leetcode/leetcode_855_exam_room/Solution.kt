package leetcode.leetcode_855_exam_room

import java.util.TreeSet

/**
 * leetcode - https://leetcode.com/problems/exam-room/?envType=problem-list-v2&envId=heap-priority-queue
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class ExamRoom(val n: Int) {
    private val seats = TreeSet<Int>()

    fun seat(): Int {
        var seatNumber = 0

        if (seats.size > 0) {
            var prev = -1
            var maxDistance = seats.first()
            seats.forEach { seat ->
                if (prev != -1) {
                    val currentDistance = (seat - prev) / 2
                    if (maxDistance < currentDistance) {
                        maxDistance = currentDistance
                        seatNumber = prev + maxDistance
                    }
                }
                prev = seat
            }
            if (maxDistance < n - 1 - seats.last()) {
                seatNumber = n - 1
            }
        }
        seats.add(seatNumber)
        return seatNumber
    }

    fun leave(p: Int) {
        seats.remove(p)
    }
}

private fun main() {

}
