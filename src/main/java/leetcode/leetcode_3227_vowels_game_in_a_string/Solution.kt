package leetcode.leetcode_3227_vowels_game_in_a_string

/**
 * leetcode - https://leetcode.com/problems/vowels-game-in-a-string/
 *
 * Using Game theory
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 7 ms, faster than 100.00%
 * Memory Usage: 38.4 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun doesAliceWin(s: String): Boolean {
    s.forEach {
        if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u') {
            return true
        }
    }
    return false
}

private fun main() {

}
