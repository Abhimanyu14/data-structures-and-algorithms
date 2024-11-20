package leetcode.leetcode_2577_minimum_time_to_visit_a_cell_in_a_grid

import java.util.LinkedList
import java.util.Queue

/**
 * leetcode - https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
data class Point(
    val x: Int,
    val y: Int,
)

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
