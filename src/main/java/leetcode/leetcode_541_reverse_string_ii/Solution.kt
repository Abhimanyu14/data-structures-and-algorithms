package leetcode.leetcode_541_reverse_string_ii

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/reverse-string-ii/
 *
 * Data Structure - [String]
 * Algorithm - String reversal
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun reverseStr(s: String, k: Int): String {
    val chars = s.toCharArray()
    fun reverse(start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }
    }
    var i = 0
    while (i <= chars.lastIndex) {
        reverse(i, min(i + k - 1, chars.lastIndex))
        i += (k * 2)
    }
    return String(chars)
}
