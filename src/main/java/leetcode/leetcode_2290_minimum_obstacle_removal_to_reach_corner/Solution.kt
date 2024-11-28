package leetcode.leetcode_2290_minimum_obstacle_removal_to_reach_corner

import java.util.PriorityQueue

/**
 * leetcode - Runtime: 301 ms, faster than 100.00%
 *
 * TODO(Abhi) - To revisit
 *
 * Using BFS
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 331 ms, faster than 100.00%
 * Memory Usage: 85.8 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun minimumObstacles(grid: Array<IntArray>): Int {
    val priorityQueue = PriorityQueue<Pair<Point, Int>> { a , b ->
        a.second - b.second
    }
    val visitedPoints = Array(grid.size) {
        BooleanArray(grid[0].size)
    }
    fun getAdjacentPoints(point: Point): List<Point> {
        val adjacentPoints = mutableListOf<Point>()
        if (point.x > 0 && !visitedPoints[point.x - 1][point.y]) {
            adjacentPoints.add(Point(point.x - 1, point.y))
        }
        if (point.y > 0 && !visitedPoints[point.x][point.y - 1]) {
            adjacentPoints.add(Point(point.x, point.y - 1))
        }
        if (point.x < grid.lastIndex && !visitedPoints[point.x + 1][point.y]) {
            adjacentPoints.add(Point(point.x + 1, point.y))
        }
        if (point.y < grid[0].lastIndex && !visitedPoints[point.x][point.y + 1]) {
            adjacentPoints.add(Point(point.x, point.y + 1))
        }
        return adjacentPoints
    }
    priorityQueue.offer(Pair(Point(0, 0), grid[0][0]))
    while (priorityQueue.isNotEmpty()) {
        val (currentPoint, currentObstacle) = priorityQueue.poll()
        if (!visitedPoints[currentPoint.x][currentPoint.y]) {
            visitedPoints[currentPoint.x][currentPoint.y] = true
            getAdjacentPoints(currentPoint).forEach { nextPoint ->
                if (nextPoint.x == grid.lastIndex && nextPoint.y == grid[0].lastIndex) {
                    return currentObstacle + grid[nextPoint.x][nextPoint.y]
                }
                priorityQueue.offer(Pair(nextPoint, currentObstacle + grid[nextPoint.x][nextPoint.y]))
            }
        }
    }
    return -1
}

/**
 * leetcode - Runtime: 301 ms, faster than 100.00%
 *
 * TODO(Abhi) - To revisit
 *
 * Using Dijkstra algorithm
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 301 ms, faster than 100.00%
 * Memory Usage: 83 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private data class Point(
    val x: Int,
    val y: Int,
)

private fun minimumObstaclesUsingDijkstra(grid: Array<IntArray>): Int {
    val minObstacles = Array(grid.size) {
        IntArray(grid[0].size) {
            Int.MAX_VALUE
        }
    }
    fun getAdjacentPoints(point: Point): List<Point> {
        val adjacentPoints = mutableListOf<Point>()
        if (point.x > 0) {
            adjacentPoints.add(Point(point.x - 1, point.y))
        }
        if (point.y > 0) {
            adjacentPoints.add(Point(point.x, point.y - 1))
        }
        if (point.x < grid.lastIndex) {
            adjacentPoints.add(Point(point.x + 1, point.y))
        }
        if (point.y < grid[0].lastIndex) {
            adjacentPoints.add(Point(point.x, point.y + 1))
        }
        return adjacentPoints
    }

    val priorityQueue = PriorityQueue<Pair<Point, Int>> { a , b ->
        a.second - b.second
    }
    val visitedPoints = Array(grid.size) {
        BooleanArray(grid[0].size)
    }
    minObstacles[0][0] = grid[0][0]
    priorityQueue.offer(Pair(Point(0, 0), grid[0][0]))
    while (priorityQueue.isNotEmpty()) {
        val (currentPoint, currentObstacle) = priorityQueue.poll()
        visitedPoints[currentPoint.x][currentPoint.y] = true
        if (minObstacles[currentPoint.x][currentPoint.y] < currentObstacle) {
            continue
        }
        getAdjacentPoints(currentPoint).forEach { nextPoint ->
            if (!visitedPoints[nextPoint.x][nextPoint.y]) {
                val updatedObstacle = minObstacles[currentPoint.x][currentPoint.y] + grid[nextPoint.x][nextPoint.y]
                if (updatedObstacle < minObstacles[nextPoint.x][nextPoint.y]) {
                    minObstacles[nextPoint.x][nextPoint.y] = updatedObstacle
                    priorityQueue.offer(Pair(nextPoint, updatedObstacle))
                }
            }
        }
    }
    return minObstacles[grid.lastIndex][grid[0].lastIndex]
}

private fun main() {

}
