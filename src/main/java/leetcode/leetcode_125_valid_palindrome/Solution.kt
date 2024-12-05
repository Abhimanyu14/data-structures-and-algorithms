package leetcode.leetcode_125_valid_palindrome

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome/
 *
 * Data Structure - NA
 * Algorithm - Two pointer single loop
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 388 ms, faster than 32.74%
 * Memory Usage: 40.1 MB, less than 58.52%
 *
 * Time -
 * Space -
 */
fun isPalindromeTwoPointer(s: String): Boolean {
    // For leetcode compiler
    // lowercaseChar() => toLowerCase()
    // code => toInt()
    var start = 0
    var end = s.lastIndex
    while (start < end) {
        if (!s[start].isLetterOrDigit()) {
            start++
        } else if (!s[end].isLetterOrDigit()) {
            end--
        } else if (!s[start].equals(s[end], ignoreCase = true)) {
            return false
        } else {
            start++
            end--
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
fun isPalindrome(s: String): Boolean {
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
