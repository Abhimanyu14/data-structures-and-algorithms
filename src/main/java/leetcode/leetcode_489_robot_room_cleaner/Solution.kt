package leetcode.leetcode_489_robot_room_cleaner

/**
 * leetcode - https://leetcode.com/problems/robot-room-cleaner/description/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun cleanRoom(robot: Robot) {
    val directions = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))
    val visited = mutableSetOf<Pair<Int, Int>>()
    fun moveBack() {
        robot.turnRight()
        robot.turnRight()
        robot.move()
        robot.turnRight()
        robot.turnRight()
    }

    fun dfs(x: Int, y: Int, directionIndex: Int) {
        var newDirectionIndex = directionIndex
        if (!visited.contains(Pair(x, y))) {
            visited.add(Pair(x, y))
            robot.clean()

            for (i in 0..3) {
                if (robot.move()) {
                    val direction = directions[directionIndex]
                    dfs(x + direction.first, y + direction.second, directionIndex)
                }
                robot.turnRight()
                newDirectionIndex = (newDirectionIndex + 1) % 4
            }
        }
        moveBack()
    }
    dfs(0, 0, 0)
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
