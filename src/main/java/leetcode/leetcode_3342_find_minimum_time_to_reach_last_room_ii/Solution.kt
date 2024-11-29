package leetcode.leetcode_3342_find_minimum_time_to_reach_last_room_ii

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/
 *
 * TODO - To revisit
 *
 * Data Structure - Priority Queue, Array and List
 * Algorithm - Dijkstra
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 251 ms, faster than 86.49%
 * Memory Usage: 133.3 MB, less than 86.49%
 *
 * Time -
 * Space -
 */
private data class Move(
    val x: Int,
    val y: Int,
    val time: Int,
    val lastMoveIsOne: Boolean,
)

private fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val visited = Array(moveTime.size) {
        BooleanArray(moveTime[0].size)
    }
    val priorityQueue = PriorityQueue<Move> { a, b ->
        a.time - b.time
    }
    priorityQueue.offer(Move(0, 0, 0, false))
    fun getNextPoints(x: Int, y: Int): List<Pair<Int, Int>> {
        val nextPoints = mutableListOf<Pair<Int, Int>>()
        if (x > 0) {
            nextPoints.add(Pair(x - 1, y))
        }
        if (y > 0) {
            nextPoints.add(Pair(x, y - 1))
        }
        if (x < moveTime.lastIndex) {
            nextPoints.add(Pair(x + 1, y))
        }
        if (y < moveTime[0].lastIndex) {
            nextPoints.add(Pair(x, y + 1))
        }
        return nextPoints
    }

    while (priorityQueue.isNotEmpty()) {
        val currentMove = priorityQueue.poll()
        if (!visited[currentMove.x][currentMove.y]) {
            visited[currentMove.x][currentMove.y] = true
            getNextPoints(currentMove.x, currentMove.y).forEach { (nextX, nextY) ->
                val nextMoveTime = max(currentMove.time, moveTime[nextX][nextY]) + if (currentMove.lastMoveIsOne) { 2 } else { 1 }
                if (nextX == moveTime.lastIndex && nextY == moveTime[0].lastIndex) {
                    return nextMoveTime
                }
                priorityQueue.offer(Move(nextX, nextY, nextMoveTime, !currentMove.lastMoveIsOne))
            }
        }
    }
    return -1
}


private fun main() {

}
