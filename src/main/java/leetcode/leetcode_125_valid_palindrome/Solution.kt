package leetcode.leetcode_125_valid_palindrome

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome/
 *
 * Data Structure - NA
 * Algorithm - Two pointer - single loop
 *
 * String methods - [isLetterOrDigit], [equals] (with ignoreCase parameter)
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 12 ms, faster than 43.71%
 * Memory Usage: 46.06 MB, less than 20.21%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.lastIndex
    while (left < right) {
        if (!s[left].isLetterOrDigit()) {
            left++
        } else if (!s[right].isLetterOrDigit()) {
            right--
        } else if (!s[left].equals(s[right], ignoreCase = true)) {
            return false
        } else {
            left++
            right--
        }
    }
    return true
}

/**
 * Naive solution with pre-processing
 *
 * Stats
 * Runtime: 341 ms, faster than 53.78%
 * Memory Usage: 41.2 MB, less than 45.93%
 */
private fun isPalindromeUsingNaive(s: String): Boolean {
    // For leetcode compiler
    // lowercaseChar() => toLowerCase()
    // code => toInt()
    val chars = s.lowercase().filter {
        it.isLetterOrDigit()
    }.map {
        it.toInt()
    }
    var index = 0
    while (index < chars.lastIndex - index) {
        if (chars[index] != chars[chars.lastIndex - index]) {
            return false
        }
        index++
    }
    return true
}

private fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
}
