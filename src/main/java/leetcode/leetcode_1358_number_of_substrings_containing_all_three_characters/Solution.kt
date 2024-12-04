package leetcode.leetcode_1358_number_of_substrings_containing_all_three_characters

/**
 * leetcode - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Data Structure - Map
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 79 ms, faster than 16.67%
 * Memory Usage: 39.7 MB, less than 6.25%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun numberOfSubstrings(s: String): Int {
    var result = 0
    val counter = mutableMapOf<Char, Int>()
    var left = -1
    var right = -1
    while (left <= s.lastIndex - 3) {
        if (left >= 0) {
            if (counter.getOrDefault(s[left], 0) == 1) {
                counter.remove(s[left])
            } else {
                counter[s[left]] = counter.getOrDefault(s[left], 0) - 1
            }
        }
        left++
        while (right < s.lastIndex && counter.size < 3) {
            right++
            counter[s[right]] = counter.getOrDefault(s[right], 0) + 1
        }
        if (counter.size == 3) {
            result += (s.lastIndex - right + 1)
        }
    }
    return result
}

private fun main() {

}
