package leetcode.leet_2000_to_2099.leet_2013_detect_squares

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/detect-squares/
 *
 * Using geometry & map
 *
 * Stats
 * Runtime: 423 ms, faster than 96.30%
 * Memory Usage: 60.7 MB, less than 88.89%
 */
private data class Point(
    val x: Int,
    val y: Int,
)

private class DetectSquares() {
    val pointsCounter = mutableMapOf<Point, Int>()

    fun add(point: IntArray) {
        pointsCounter[Point(point[0], point[1])] = pointsCounter.getOrDefault(Point(point[0], point[1]), 0) + 1
    }

    fun count(point: IntArray): Int {
        var result = 0
        pointsCounter.keys.forEach { diagonalPoint ->
            val xDiff = abs(diagonalPoint.x - point[0])
            if (xDiff != 0 &&
                xDiff == abs(diagonalPoint.y - point[1]) &&
                pointsCounter.contains(Point(point[0], diagonalPoint.y)) &&
                pointsCounter.contains(Point(diagonalPoint.x, point[1]))
            ) {
                result += (
                        pointsCounter.getOrDefault(Point(point[0], diagonalPoint.y), 0) *
                                pointsCounter.getOrDefault(Point(diagonalPoint.x, point[1]), 0) *
                                pointsCounter.getOrDefault(Point(diagonalPoint.x, diagonalPoint.y), 0)
                        )
            }
        }
        return result
    }
}

/**
 * leetcode - https://leetcode.com/problems/detect-squares/
 *
 * Using geometry & map
 *
 * Stats
 * Runtime: 423 ms, faster than 96.30%
 * Memory Usage: 60.7 MB, less than 88.89%
 */
private class DetectSquaresReadable() {
    val pointsCounter = mutableMapOf<Point, Int>()

    fun add(point: IntArray) {
        val pointToAdd = Point(point[0], point[1])
        pointsCounter[pointToAdd] = pointsCounter.getOrDefault(pointToAdd, 0) + 1
    }

    fun count(point: IntArray): Int {
        var result = 0
        pointsCounter.keys.forEach { diagonalPoint ->
            val xDiff = abs(diagonalPoint.x - point[0])
            val yDiff = abs(diagonalPoint.y - point[1])

            val pointWithSameX = Point(point[0], diagonalPoint.y)
            val pointWithSameY = Point(diagonalPoint.x, point[1])
            val pointWithSameXCount = pointsCounter.getOrDefault(pointWithSameX, 0)
            val pointWithSameYCount = pointsCounter.getOrDefault(pointWithSameY, 0)
            val diagonalPointCount = pointsCounter.getOrDefault(diagonalPoint, 0)

            if (xDiff != 0 && xDiff == yDiff &&
                pointsCounter.contains(pointWithSameX) && pointsCounter.contains(pointWithSameY)
            ) {
                result += (pointWithSameXCount * pointWithSameYCount * diagonalPointCount)
            }
        }
        return result
    }
}

private fun main() {

}
