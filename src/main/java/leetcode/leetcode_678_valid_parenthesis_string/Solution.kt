package leetcode.leetcode_678_valid_parenthesis_string

/**
 * leetcode - https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Using two pointers
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 138 ms, faster than 60.46%
 * Memory Usage: 34.8 MB, less than 39.53%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun checkValidString(s: String): Boolean {
    var openCount = 0
    var closeCount = 0

    // Traverse the string from both ends simultaneously
    for (i in s.indices) {
        // Count open parentheses or asterisks
        if (s[i] == '(' || s[i] == '*') {
            openCount++
        } else {
            openCount--
        }

        // Count close parentheses or asterisks
        if (s[s.lastIndex - i] == ')' || s[s.lastIndex - i] == '*') {
            closeCount++
        } else {
            closeCount--
        }

        // If at any point open count or close count goes negative, the string is invalid
        if (openCount < 0 || closeCount < 0) {
            return false
        }
    }

    // If open count and close count are both non-negative, the string is valid
    return true
}

private fun main() {

}
