package leetcode.leetcode_3360_stone_removal_game

/**
 * leetcode - https://leetcode.com/problems/stone-removal-game/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.5 MB, less than 10.87%
 *
 * Time -
 * Space -
 */
private fun canAliceWin(n: Int): Boolean {
    var current = n
    var temp = 10
    var result = false
    while (current >= temp) {
        result = !result
        current -= temp
        temp--
    }
    return result
}

private fun main() {

}
