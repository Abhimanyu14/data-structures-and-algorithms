package leetcode.leetcode_657_robot_return_to_origin

/**
 * leetcode - https://leetcode.com/problems/robot-return-to-origin/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 7 ms, faster than 91.67%
 * Memory Usage: 38.3 MB, less than 30.56%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun judgeCircle(moves: String): Boolean {
    var x = 0
    var y = 0
    for (move in moves) {
        when (move) {
            'U' -> y++
            'D' -> y--
            'L' -> x--
            'R' -> x++
        }
    }
    return x == 0 && y == 0
}

private fun main() {

}
