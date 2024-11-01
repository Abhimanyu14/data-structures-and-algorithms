package leetcode.leetcode_1750_minimum_length_of_string_after_deleting_similar_ends

/**
 * leetcode - https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 212 ms, faster than 100.00%
 * Memory Usage: 39.1 MB, less than 100.00%
 */
private fun minimumLength(s: String): Int {
    var start = 0
    var end = s.lastIndex
    while (start < end && s[start] == s[end]) {
        val char = s[start]
        while (start <= end && s[start] == char) {
            start++
        }
        while (start < end && s[end] == char) {
            end--
        }
    }
    return end - start + 1
}

private fun main() {

}
