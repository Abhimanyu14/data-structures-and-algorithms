package leetcode.leetcode_3342_find_minimum_time_to_reach_last_room_ii

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/
 *
 * Data Structure - [PriorityQueue], [Array] and [List]
 * Algorithm - BFS, Dijkstra
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Uber
 */
private data class Move(
    val x: Int,
    val y: Int,
    val time: Int,
    val isOdd: Boolean,
)

class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val priorityQueue = PriorityQueue<Move> { a, b ->
            a.time - b.time
        }
        val visited = Array(moveTime.size) {
            BooleanArray(moveTime[0].size)
        }
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        priorityQueue.offer(Move(0, 0, 0, true))
        while (priorityQueue.isNotEmpty()) {
            val (x, y, time, isOdd) = priorityQueue.poll()
            if (x == moveTime.lastIndex && y == moveTime[0].lastIndex) {
                return time
            }
            if (visited[x][y]) {
                continue
            }
            visited[x][y] = true
            directions.forEach { (x1, y1) ->
                if (x + x1 >= 0 && x + x1 <= moveTime.lastIndex && y + y1 >= 0 && y + y1 <= moveTime[0].lastIndex && !visited[x + x1][y + y1]) {
                    if (isOdd) {
                        priorityQueue.offer(Move(x + x1, y + y1, max(moveTime[x + x1][y + y1], time) + 1, false))
                    } else {
                        priorityQueue.offer(Move(x + x1, y + y1, max(moveTime[x + x1][y + y1], time) + 2, true))
                    }
                }
            }
        }
        return 0
    }
}


private fun main() {

}
