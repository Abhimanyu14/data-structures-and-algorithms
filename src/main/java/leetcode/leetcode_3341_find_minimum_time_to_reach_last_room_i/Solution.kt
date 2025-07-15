package leetcode.leetcode_3341_find_minimum_time_to_reach_last_room_i

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue], [Array] and [List]
 * Algorithm - Dijkstra
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 166 ms, faster than 100.00%
 * Memory Usage: 47.88 MB, less than 60.00%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Google
 */
private fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val queue = PriorityQueue<Triple<Int, Int, Int>> { a, b -> // Value, x, y
        a.first - b.first
    }
    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    val visited = Array(moveTime.size) {
        BooleanArray(moveTime[0].size)
    }
    queue.offer(Triple(0, 0, 0))
    while (queue.isNotEmpty()) {
        val (time, x, y) = queue.poll()
        if (visited[x][y]) {
            continue
        }
        visited[x][y] = true
        if (x == moveTime.lastIndex && y == moveTime[0].lastIndex) {
            return time
        }
        for ((x1, y1) in directions) {
            if ((x + x1 >= 0 && x + x1 <= moveTime.lastIndex && y + y1 >= 0 && y + y1 <= moveTime[0].lastIndex) && !visited[x + x1][y + y1]) {
                queue.offer(Triple(max(time, moveTime[x + x1][y + y1]) + 1, x + x1, y + y1))
            }
        }
    }
    return -1
}

private fun main() {

}
