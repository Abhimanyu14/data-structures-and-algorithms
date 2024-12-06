package leetcode.leetcode_3238_find_the_number_of_winning_players

/**
 * leetcode - https://leetcode.com/problems/find-the-number-of-winning-players/
 *
 * Data Structure - Array
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 43 MB, less than 83.33%
 *
 * Time - O(11 * n)
 * Space - O(11 * n)
 */
private fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
    val counter = Array(n) {
        IntArray(11)
    }
    var result = 0
    pick.forEach { (player, color) ->
        counter[player][color]++
    }
    counter.forEachIndexed { player, colors ->
        for (color in colors) {
            if (color > player) {
                result++
                break
            }
        }
    }
    return result
}

private fun main() {

}
