package leetcode.leetcode_680_valid_palindrome_ii

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 264 ms, faster than 49.49%
 * Memory Usage: 39.3 MB, less than 16.33%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun validPalindrome(s: String): Boolean {
    fun isPalindrome(start: Int, end: Int, buffer: Int): Boolean {
        var first = start
        var last = end
        while (first < last) {
            if (s[first] == s[last]) {
                first++
                last--
            } else {
                if (buffer == 0) {
                    return false
                }
                return isPalindrome(first + 1, last, 0) || isPalindrome(first, last - 1, 0)
            }
        }
        return true
    }
    return isPalindrome(0, s.lastIndex, 1)
}

private fun main() {

}
