package leetcode.leetcode_0_to_99.leetcode_32_longest_valid_parentheses

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Using counters
 *
 * Stats
 * Runtime: 174 ms, faster than 52.70%
 * Memory Usage: 37.4 MB, less than 24.32%
 */
private fun longestValidParentheses(s: String): Int {
    var left = 0
    var right = 0
    var result = 0
    s.forEach { char ->
        if (char == '(') {
            left++
        } else {
            right++
        }
        if (left == right) {
            result = max(result, (left + right))
        } else if (right > left) {
            right = 0
            left = 0
        }
    }
    right = 0
    left = 0
    for (i in s.lastIndex downTo 0) {
        if (s[i] == '(') {
            left++
        } else {
            right++
        }
        if (left == right) {
            result = max(result, (left + right))
        } else if (left > right) {
            right = 0
            left = 0
        }
    }
    return result
}

private fun main() {

}
