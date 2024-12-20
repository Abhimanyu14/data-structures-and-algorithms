package leetcode.leetcode_434_number_of_segments_in_a_string

/**
 * leetcode - https://leetcode.com/problems/number-of-segments-in-a-string/
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 8 ms, faster than 78.79%
 * Memory Usage: 35.9 MB, less than 63.64%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun countSegments(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    var result = 0
    var current = 0
    while (current <= s.lastIndex) {
        if (s[current] != ' ') {
            result++
        }
        while (current <= s.lastIndex && s[current] != ' ') {
            current++
        }
        while (current <= s.lastIndex && s[current] == ' ') {
            current++
        }
    }
    return result
}

private fun main() {

}
