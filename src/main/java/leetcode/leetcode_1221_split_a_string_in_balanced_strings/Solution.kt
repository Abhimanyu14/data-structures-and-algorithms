package leetcode.leetcode_1221_split_a_string_in_balanced_strings

/**
 * leetcode - https://leetcode.com/problems/split-a-string-in-balanced-strings/
 *
 * Using counter and iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 42.86%
 * Memory Usage: 34 MB, less than 36.84%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun balancedStringSplit(s: String): Int {
    var result = 0
    var current = 0
    s.forEach {
        if (it == 'R') {
            current++
        } else {
            current--
        }
        if (current == 0) {
            result++
        }
    }
    return result
}

private fun main() {

}
