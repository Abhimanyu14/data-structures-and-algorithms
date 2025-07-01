package leetcode.leetcode_3330_find_the_original_typed_string_i

/**
 * leetcode - https://leetcode.com/problems/find-the-original-typed-string-i
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
 *
 * Companies -
 */
private fun possibleStringCount(word: String): Int {
    var result = 1
    for (i in 1..word.lastIndex) {
        if (word[i] == word[i - 1]) {
            result++
        }
    }
    return result
}

private fun main() {

}
