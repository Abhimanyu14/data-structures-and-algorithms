package leetcode.leetcode_3222_find_the_winning_player_in_coin_game

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-the-winning-player-in-coin-game/
 *
 * Data Structure - NA
 * Algorithm - Using Maths - min and mod
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 35.5 MB, less than 25.00%
 *
 * Time - O(1)
 * Space - O(1)
 */
private fun winningPlayer(x: Int, y: Int): String {
    return if (min(x, y / 4) % 2 == 0) {
        "Bob"
    } else {
        "Alice"
    }
}

private fun main() {

}
