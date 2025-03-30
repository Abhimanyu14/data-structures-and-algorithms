package leetcode.leetcode_680_valid_palindrome_ii

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Data Structure - NA
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
        var left = start
        var right = end
        while (left < right) {
            if (s[left] == s[right]) {
                left++
                right--
            } else {
                if (buffer == 0) {
                    return false
                }
                return isPalindrome(left + 1, right, 0) || isPalindrome(left, right - 1, 0)
            }
        }
        return true
    }
    return isPalindrome(0, s.lastIndex, 1)
}

private fun main() {

}
