package leetcode.leetcode_1937_maximum_number_of_points_with_cost

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-points-with-cost/?envType=daily-question&envId=2024-08-17
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
private fun maxPoints(points: Array<IntArray>): Long {
    val cols = points[0].size
    val currentRow = LongArray(cols)
    var previousRow = LongArray(cols)

    for (row in points) {
        // runningMax holds the maximum value generated in the previous iteration of each loop
        var runningMax: Long = 0

        // Left to right pass
        for (col in 0..<cols) {
            runningMax = max((runningMax - 1).toDouble(), previousRow[col].toDouble()).toLong()
            currentRow[col] = runningMax
        }

        runningMax = 0
        // Right to left pass
        for (col in cols - 1 downTo 0) {
            runningMax = max((runningMax - 1).toDouble(), previousRow[col].toDouble()).toLong()
            currentRow[col] = (max(currentRow[col].toDouble(), runningMax.toDouble()) +
                    row[col]).toLong()
        }

        // Update previousRow for next iteration
        previousRow = currentRow
    }

    // Find maximum points in the last row
    var maxPoints: Long = 0
    for (col in 0..<cols) {
        maxPoints = max(maxPoints.toDouble(), previousRow[col].toDouble()).toLong()
    }

    return maxPoints
}

private fun main() {

}
