package leetcode.leetcode_5_longest_palindromic_substring

import data_structures_and_algorithms.string.isStringPalindrome
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-palindromic-substring/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Expand around center
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 204 ms, faster than 96.92%
 * Memory Usage: 36.1 MB, less than 84.74%
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
        return ""
    }
    var start = 0
    var end = 0
    fun expandAroundCenter(s: String, start: Int, end: Int): Int {
        var left = start
        var right = end
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        return right - left - 1
    }
    for (i in s.indices) {
        val len1 = expandAroundCenter(s, i, i)
        val len2 = expandAroundCenter(s, i, i + 1)
        val len = max(len1, len2)
        if (len > end - start) {
            start = i - (len - 1) / 2
            end = i + len / 2
        }
    }
    return s.substring(start, end + 1)
}

/**
 * leetcode - https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Using recursion
 */
fun longestPalindromeUsingRecursion(s: String): String {
    if (s.isEmpty() || s.length == 1 || isStringPalindrome(s)) {
        return s
    }
    val x = longestPalindrome(s.substring(0, s.length - 1))
    val y = longestPalindrome(s.substring(1, s.length))
    return if (x.length > y.length) {
        x
    } else {
        y
    }
}

private fun main() {
    val input = "babad"
    val input1 = "cbbd"
    val input2 = "a"
    val input3 = "ac"
    // This requires more optimal solution
    val input4 = "babaddtattarrattatddetartrateedredividerb"

    println(longestPalindrome(input))
//    println(longestPalindrome(input1))
//    println(longestPalindrome(input2))
//    println(longestPalindrome(input3))
    // println(longestPalindrome(input4))
}
