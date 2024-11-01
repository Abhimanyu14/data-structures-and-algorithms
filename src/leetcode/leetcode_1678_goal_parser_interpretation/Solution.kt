package leetcode.leetcode_1678_goal_parser_interpretation

/**
 * leetcode - https://leetcode.com/problems/goal-parser-interpretation/
 *
 * Using String builder
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 136 ms, faster than 87.14%
 * Memory Usage: 34.6 MB, less than 45.71%
 *
 * Time -
 * Space -
 */
private fun interpret(command: String): String {
    val result = StringBuilder()
    var i = 0
    while (i < command.length) {
        if (command[i] == 'G') {
            result.append('G')
            i++
        } else if (command[i] == '(' && command[i + 1] == ')') {
            result.append('o')
            i += 2
        } else {
            result.append("al")
            i += 4
        }
    }
    return result.toString()
}

private fun main() {

}
