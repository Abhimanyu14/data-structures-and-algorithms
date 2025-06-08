package leetcode.leetcode_489_robot_room_cleaner

/**
 * leetcode - https://leetcode.com/problems/robot-room-cleaner/description/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Grid
 * Algorithm - Backtracking (Recursion)
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(M*N)
 * Space - O(1)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun cleanRoom(robot: Robot) {
    val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))
    val visited = mutableSetOf<Pair<Int, Int>>()
    fun Robot.goBack() {
        this.turnRight()
        this.turnRight()
        this.move()
        this.turnRight()
        this.turnRight()
    }

    fun backtrack(x: Int, y: Int, direction: Int) {
        visited.add(Pair(x, y))
        robot.clean()
        for (i in 0..3) {
            val newDirection = (direction + i) % 4
            val newX = x + directions[newDirection][0]
            val newY = y + directions[newDirection][1]
            if (!visited.contains(Pair(newX, newY)) && robot.move()) {
                backtrack(newX, newY, newDirection)
                robot.goBack()
            }
            robot.turnRight()
        }
    }
    backtrack(0, 0, 0)
}

class Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    fun move(): Boolean {
        return false
    }

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft() {}
    fun turnRight() {}

    // Clean the current cell.
    fun clean() {}
}

private fun main() {

}
