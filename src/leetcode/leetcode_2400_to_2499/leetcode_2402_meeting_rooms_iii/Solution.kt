package leetcode.leetcode_2400_to_2499.leetcode_2402_meeting_rooms_iii

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/meeting-rooms-iii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
data class RoomData(
    val no: Int,
    val meetingsCount: Int = 0,
    val nextFree: Int = 0
)

private class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val sortedMeetings = meetings.sortedBy {
            it[0]
        }
        val rooms = PriorityQueue<RoomData> { a, b ->
            a.nextFree - b.nextFree
        }
        var temp: RoomData
        var temp2: RoomData
        val tempList = mutableListOf<RoomData>()
        sortedMeetings.forEach { meeting ->
            if (rooms.isNotEmpty() && rooms.peek().nextFree <= meeting[0]) {
                tempList.clear()
                temp = rooms.poll()
                tempList.add(temp)
                while (rooms.isNotEmpty() && rooms.peek().nextFree <= meeting[0]) {
                    temp2 = rooms.poll()
                    tempList.add(temp2)
                    if (temp2.no < temp.no) {
                        temp = temp2
                    }
                }
                rooms.offer(
                    temp.copy(
                        meetingsCount = temp.meetingsCount + 1,
                        nextFree = meeting[1],
                    )
                )
                tempList.forEach {
                    if (it.no != temp.no) {
                        rooms.offer(it)
                    }
                }
            } else if (rooms.size < n) {
                rooms.offer(RoomData(rooms.size, 1, meeting[1]))
            } else {
                temp = rooms.poll()
                rooms.offer(
                    temp.copy(
                        meetingsCount = temp.meetingsCount + 1,
                        nextFree = temp.nextFree + (meeting[1] - meeting[0]),
                    )
                )
            }
        }
        var resultRoom = rooms.poll()
        while (rooms.isNotEmpty()) {
            temp = rooms.poll()
            if (resultRoom.meetingsCount < temp.meetingsCount || (resultRoom.meetingsCount == temp.meetingsCount && resultRoom.no > temp.no)) {
                resultRoom = temp
            }
        }
        return resultRoom.no
    }
}

private fun main() {
    val solution = Solution()
//    println(
//        solution.mostBooked(
//            4, arrayOf(
//                intArrayOf(18, 19),
//                intArrayOf(3, 12),
//                intArrayOf(17, 19),
//                intArrayOf(2, 13),
//                intArrayOf(7, 10),
//            )
//        )
//    )
    println(
        solution.mostBooked(
            2,
            arrayOf(
                intArrayOf(10, 11),
                intArrayOf(2, 10),
                intArrayOf(1, 17),
                intArrayOf(9, 13),
                intArrayOf(18, 20),
            )
        )
    )
}
