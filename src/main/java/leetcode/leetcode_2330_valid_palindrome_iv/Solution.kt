package leetcode.leetcode_2330_valid_palindrome_iv

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome-iv/description/
 *
 * Data Structure -
 * Algorithm - Iteration and counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon
 */
private fun makePalindrome(s: String): Boolean {
    var count = 0
    var left = 0
    var right = s.lastIndex
    while (left < right) {
        if (s[left] != s[right]) {
            count++
            if (count > 2) {
                return false
            }
        }
        left++
        right--
    }
    return true
}

private fun main() {

}
