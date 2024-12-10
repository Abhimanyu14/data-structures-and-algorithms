package leetcode.leetcode_2981_find_longest_special_substring_that_occurs_thrice_i

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/?envType=daily-question&envId=2024-12-10
 *
 * Data Structure - Array and Map
 * Algorithm - Counting and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 14 ms, faster than 66.67%
 * Memory Usage: 38.3 MB, less than 50.00%
 *
 * Time - O(N * N)
 * Space - O(26 * N)
 */
private fun maximumLength(s: String): Int {
    var result = 0
    var prevChar: Char = s[0]
    var prevCharCount = 1
    val counter = Array(26) { IntArray(s.length + 1) }
    counter[prevChar - 'a'][1]++
    for (i in 1..s.lastIndex) {
        if (s[i] == prevChar) {
            prevCharCount++
            for (j in 1..prevCharCount) {
                counter[prevChar - 'a'][j]++
            }
        } else {
            prevChar = s[i]
            prevCharCount = 1
            counter[prevChar - 'a'][1]++
        }
    }
    for (i in 0..<26) {
        for (j in s.length downTo 1) {
            if (counter[i][j] >= 3) {
                result = max(result, j)
                break
            }
        }
    }
    return if (result == 0) {
        -1
    } else {
        result
    }
}

private fun main() {

}
