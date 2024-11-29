package leetcode.leetcode_678_valid_parenthesis_string

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Data Structure - NA
 * Algorithm - Using ranges
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 35.2 MB, less than 25.00%
 *
 * Time - O(3 ^ N)
 * Space - O(N) - Recursion stack
 */
private fun checkValidString(s: String): Boolean {
    var minimum = 0
    var maximum = 0
    s.forEach {
        when (it) {
            '(' -> {
                minimum++
                maximum++
            }

            ')' -> {
                minimum = max(minimum - 1, 0)
                maximum--
                if (maximum < 0){
                    return false
                }
            }

            else -> {
                minimum = max(minimum - 1, 0)
                maximum++
            }
        }
    }
    return minimum == 0
}

/**
 * leetcode - https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Data Structure - NA
 * Algorithm - Two pointers
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
private fun checkValidStringUsingTwoPointer(s: String): Boolean {
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

/**
 * leetcode - https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Data Structure - Array
 * Algorithm - Dynamic programming - Memoization
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 4 ms, faster than 39.39%
 * Memory Usage: 36.4 MB, less than 14.58%
 *
 * Time - O(3 ^ N)
 * Space - O(N) - Recursion stack
 */
private fun checkValidStringUsingMemoization(s: String): Boolean {
    val dp = Array(s.length) {
        Array<Boolean?>(s.length) { null }
    }

    fun isValid(index: Int, count: Int): Boolean {
        if (count < 0) {
            return false
        }
        if (index == s.length) {
            return count == 0
        }
        dp[index][count]?.let {
            return it
        }
        dp[index][count] = if (s[index] == '(') {
            isValid(index + 1, count + 1)
        } else if (s[index] == ')') {
            isValid(index + 1, count - 1)
        } else {
            (isValid(index + 1, count + 1) || isValid(index + 1, count) || isValid(index + 1, count - 1))
        }
        return dp[index][count] ?: false
    }
    return isValid(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(3 ^ N)
 * Space - O(N) - Recursion stack
 */
private fun checkValidStringUsingRecursion(s: String): Boolean {
    fun isValid(index: Int, count: Int): Boolean {
        if (count < 0) {
            return false
        }
        if (index == s.length) {
            return count == 0
        }
        return if (s[index] == '(') {
            isValid(index + 1, count + 1)
        } else if (s[index] == ')') {
            isValid(index + 1, count - 1)
        } else {
            (isValid(index + 1, count + 1) || isValid(index + 1, count) || isValid(index + 1, count - 1))
        }
    }
    return isValid(0, 0)
}

private fun main() {

}
