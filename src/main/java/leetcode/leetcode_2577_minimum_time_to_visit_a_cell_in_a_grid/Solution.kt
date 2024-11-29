package leetcode.leetcode_2577_minimum_time_to_visit_a_cell_in_a_grid

import java.util.LinkedList
import java.util.Queue
import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Array, List and PriorityQueue
 * Algorithm - Dijkstra
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 335 ms, faster than 50.00%
 * Memory Usage: 59.8 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private data class Point(
    val x: Int,
    val y: Int,
)

fun minimumTime(grid: Array<IntArray>): Int {
    if (grid[0][1] > 1 && grid[1][0] > 1) {
        return -1
    }
    val visited = Array(grid.size) {
        BooleanArray(grid[0].size)
    }

    fun getNextMoves(currentPoint: Point): List<Point> {
        val moves = mutableListOf<Point>()
        if (currentPoint.x > 0 && !visited[currentPoint.x - 1][currentPoint.y]) {
            moves.add(Point(currentPoint.x - 1, currentPoint.y))
        }
        if (currentPoint.y > 0 && !visited[currentPoint.x][currentPoint.y - 1]) {
            moves.add(Point(currentPoint.x, currentPoint.y - 1))
        }
        if (currentPoint.x < grid.lastIndex && !visited[currentPoint.x + 1][currentPoint.y]) {
            moves.add(Point(currentPoint.x + 1, currentPoint.y))
        }
        if (currentPoint.y < grid[0].lastIndex && !visited[currentPoint.x][currentPoint.y + 1]) {
            moves.add(Point(currentPoint.x, currentPoint.y + 1))
        }
        return moves
    }

    val priorityQueue = PriorityQueue<Pair<Point, Int>> { a, b ->
        a.second - b.second
    }
    priorityQueue.offer(Pair(Point(0, 0), 0))
    while (priorityQueue.isNotEmpty()) {
        val (currentPoint, currentTime) = priorityQueue.poll()
        if (!visited[currentPoint.x][currentPoint.y]) {
            visited[currentPoint.x][currentPoint.y] = true
            getNextMoves(currentPoint).forEach { nextPoint ->
                val updatedTime = if (grid[nextPoint.x][nextPoint.y] <= currentTime + 1) {
                    currentTime + 1
                } else {
                    if ((grid[nextPoint.x][nextPoint.y] - currentTime) % 2 == 0) {
                        grid[nextPoint.x][nextPoint.y] + 1
                    } else {
                        grid[nextPoint.x][nextPoint.y]
                    }
                }
                if (nextPoint.x == grid.lastIndex && nextPoint.y == grid[0].lastIndex) {
                    return updatedTime
                }
                priorityQueue.offer(Pair(nextPoint, updatedTime))
            }
        }
    }
    return -1
}

/**
 * leetcode - https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/
 *
 * Using BFS
 *
 * Difficulty - Hard
 *
 * Stats
 * TLE
 *
 * Time -
 * Space -
 */
private fun minimumTimeUsingBruteForce(grid: Array<IntArray>): Int {
    if (grid[0][1] > 1 && grid[1][0] > 1) {
        return -1
    }
    fun getNextMoves(currentPoint: Point, currentTime: Int): List<Point> {
        val moves = mutableListOf<Point>()
        if (currentPoint.x > 0 && grid[currentPoint.x - 1][currentPoint.y] <= (currentTime + 1)) {
            moves.add(Point(currentPoint.x - 1, currentPoint.y))
        }
        if (currentPoint.y > 0 && grid[currentPoint.x][currentPoint.y - 1] <= (currentTime + 1)) {
            moves.add(Point(currentPoint.x, currentPoint.y - 1))
        }
        if (currentPoint.x < grid.lastIndex && grid[currentPoint.x + 1][currentPoint.y] <= (currentTime + 1)) {
            moves.add(Point(currentPoint.x + 1, currentPoint.y))
        }
        if (currentPoint.y < grid[0].lastIndex && grid[currentPoint.x][currentPoint.y + 1] <= (currentTime + 1)) {
            moves.add(Point(currentPoint.x, currentPoint.y + 1))
        }
        return moves
    }

    val queue: Queue<Pair<Point, Int>> = LinkedList()
    queue.offer(Pair(Point(0, 0), 0))
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        getNextMoves(current.first, current.second).forEach {
            if (it.x == grid.lastIndex && it.y == grid[0].lastIndex) {
                return current.second + 1
            } else {
                queue.offer(Pair(it, current.second + 1))
            }
        }
    }
    return -1
}


private fun main() {

}
