package leetcode.leetcode_3341_find_minimum_time_to_reach_last_room_i

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
 *
 * TODO - To revisit
 *
 * Data Structure - Priority Queue, Array and List
 * Algorithm - Dijkstra
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 266 ms, faster than 28.57%
 * Memory Usage: 41.7 MB, less than 66.07%
 *
 * Time -
 * Space -
 */
private data class Point(
    val x: Int,
    val y: Int,
)

private fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val visited = Array(moveTime.size) {
        BooleanArray(moveTime[0].size)
    }
    val priorityQueue = PriorityQueue<Pair<Point, Int>> { a, b ->
        a.second - b.second
    }
    fun getNextMoves(point: Point): List<Point> {
        val nextPoints = mutableListOf<Point>()
        if (point.x > 0) {
            nextPoints.add(Point(point.x - 1, point.y))
        }
        if (point.y > 0) {
            nextPoints.add(Point(point.x, point.y - 1))
        }
        if (point.x < moveTime.lastIndex) {
            nextPoints.add(Point(point.x + 1, point.y))
        }
        if (point.y < moveTime[0].lastIndex) {
            nextPoints.add(Point(point.x, point.y + 1))
        }
        return nextPoints
    }
    priorityQueue.offer(Pair(Point(0, 0), 0))
    while (priorityQueue.isNotEmpty()) {
        val (currentPoint, currentTime) = priorityQueue.poll()
        if (!visited[currentPoint.x][currentPoint.y]) {
            visited[currentPoint.x][currentPoint.y] = true
            getNextMoves(currentPoint).forEach { nextPoint ->
                if (nextPoint.x  == moveTime.lastIndex && nextPoint.y == moveTime[0].lastIndex) {
                    return max(currentTime + 1, moveTime[nextPoint.x][nextPoint.y] + 1)
                }
                priorityQueue.offer(Pair(nextPoint, max(currentTime + 1, moveTime[nextPoint.x][nextPoint.y] + 1)))
            }
        }
    }
    return -1
}

private fun main() {

}
