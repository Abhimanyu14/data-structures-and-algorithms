package leetcode.leetcode_3330_find_the_original_typed_string_i

/**
 * leetcode - https://leetcode.com/problems/find-the-encrypted-string/
 *
 * Data Structure - NA
 * Algorithm - Counting and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 167 ms, faster than 39.19%
 * Memory Usage: 37.2 MB, less than 8.11%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun possibleStringCount(word: String): Int {
    var result = 1
    var prev = word[0]
    for (i in 1..word.lastIndex) {
        if (word[i] == prev) {
            result++
        }
        prev = word[i]
    }
    return result
}

private fun main() {

}
