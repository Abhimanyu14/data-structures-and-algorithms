package leetcode.leetcode_647_palindromic_substrings

/**
 * leetcode - https://leetcode.com/problems/palindromic-substrings/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun countSubstrings(s: String): Int {
    var result = 0
    fun getCount(start: Int, end: Int): Int {
        var count = 0
        var left = start
        var right = end
        while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
            count++
            left--
            right++
        }
        return count
    }
    for (i in s.indices) {
        result += getCount(i, i) + getCount(i, i + 1)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/palindromic-substrings/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun countSubstringsUsingRecursion(s: String): Int {
    fun getCount(left: Int, right: Int): Int {
        if (left < 0 || right > s.lastIndex) {
            return 0
        }
        if (s[left] != s[right]) {
            return 0
        }
        return 1 + getCount(left - 1, right + 1)
    }

    var result = 0
    for (i in 0..<s.lastIndex) {
        result += getCount(i, i)
        result += getCount(i, i + 1)
    }
    result += getCount(s.lastIndex, s.lastIndex)
    return result
}

private fun main() {

}
