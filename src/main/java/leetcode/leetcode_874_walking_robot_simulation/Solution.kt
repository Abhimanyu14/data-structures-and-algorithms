package leetcode.leetcode_874_walking_robot_simulation

import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/walking-robot-simulation/?envType=daily-question&envId=2024-09-04
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */

private class Solution {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        // Store obstacles in an HashSet for efficient lookup
        val obstacleSet: MutableSet<Int> = HashSet()
        for (obstacle in obstacles) {
            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]))
        }

        // Define direction vectors: North, East, South, West
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

        val currentPosition = intArrayOf(0, 0)
        var maxDistanceSquared = 0
        var currentDirection = 0 // 0: North, 1: East, 2: South, 3: West

        for (command in commands) {
            if (command == -1) {
                // Turn right
                currentDirection = (currentDirection + 1) % 4
                continue
            }
            if (command == -2) {
                // Turn left
                currentDirection = (currentDirection + 3) % 4
                continue
            }

            // Move forward
            val direction = directions[currentDirection]
            for (step in 0..<command) {
                val nextX = currentPosition[0] + direction[0]
                val nextY = currentPosition[1] + direction[1]
                if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
                    break
                }
                currentPosition[0] = nextX
                currentPosition[1] = nextY
            }

            maxDistanceSquared = max(
                maxDistanceSquared.toDouble(),
                (currentPosition[0] * currentPosition[0] +
                        currentPosition[1] * currentPosition[1]).toDouble()
            ).toInt()
        }

        return maxDistanceSquared
    }

    // Hash function to convert (x, y) coordinates to a unique integer value
    private fun hashCoordinates(x: Int, y: Int): Int {
        return x + HASH_MULTIPLIER * y
    }

    companion object {
        private const val HASH_MULTIPLIER = 60001 // Slightly larger than 2 * max coordinate value
    }
}

private fun main() {

}
