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
 * Time - O(N)
 * Space - O(N)
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

private fun validPalindromeUsingRecursion(s: String): Boolean {
    fun isValid (start: Int, end: Int, deleteCount: Int) : Boolean {
        if (deleteCount < 0) {
            return false
        }
        if (start == end || start > end) {
            return true
        }
        if (s[start] == s[end]) {
            return isValid(start + 1, end - 1, deleteCount)
        }
        return isValid(start, end - 1, deleteCount - 1) || isValid(start + 1, end, deleteCount - 1)
    }
    return isValid(0, s.lastIndex, 1)
}

private fun main() {

}
