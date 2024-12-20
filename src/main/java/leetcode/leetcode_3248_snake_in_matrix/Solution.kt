package leetcode.leetcode_3248_snake_in_matrix

/**
 * leetcode - https://leetcode.com/problems/snake-in-matrix/
 *
 * Data Structure - Map
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 5 ms, faster than 23.08%
 * Memory Usage: 38.4 MB, less than 7.69%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
    var result = 0
    for (command in commands) {
        when (command) {
            "RIGHT" -> {
                result += 1
            }

            "LEFT" -> {
                result += -1
            }

            "UP" -> {
                result += -n
            }

            "DOWN" -> {
                result += n
            }
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/snake-in-matrix/
 *
 * Data Structure - Map
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 7.69%
 * Memory Usage: 38.4 MB, less than 7.69%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun finalPositionOfSnakeUsingMap(n: Int, commands: List<String>): Int {
    var result = 0
    val map = mapOf("RIGHT" to 1, "LEFT" to -1, "UP" to -n, "DOWN" to n)
    for (command in commands) {
        result += map.getOrDefault(command, 0)
    }
    return result
}

private fun main() {

}
