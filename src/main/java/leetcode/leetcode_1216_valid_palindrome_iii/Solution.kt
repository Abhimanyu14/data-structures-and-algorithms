package leetcode.leetcode_1216_valid_palindrome_iii

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome-iii/description/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Recursion & Memoization
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun isValidPalindrome(s: String, k: Int): Boolean {
    val cache = mutableMapOf<Triple<Int, Int, Int>, Boolean>()
    fun isPalindrome(left: Int, right: Int, remaining: Int): Boolean {
        cache[Triple(left, right, remaining)]?.let {
            return it
        }
        if (left >= right) {
            cache[Triple(left, right, remaining)] = true
            return true
        }
        cache[Triple(left, right, remaining)] = if (s[left] == s[right]) {
            isPalindrome(left + 1, right - 1, remaining)
        } else if (remaining > 0) {
            isPalindrome(left, right - 1, remaining - 1) || isPalindrome(left + 1, right, remaining - 1)
        } else {
            false
        }
        return cache[Triple(left, right, remaining)]!!
    }
    return isPalindrome(0, s.lastIndex, k)
}

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome-iii/description/
 * Premium Question
 *
 * Data Structure - Two Pointers
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun isValidPalindromeUsingBruteForce(s: String, k: Int): Boolean {
    fun isPalindrome(left: Int, right: Int, remaining: Int): Boolean {
        if (remaining < 0) {
            return false
        }
        if (left >= right) {
            return true
        }
        if (s[left] == s[right]) {
            return isPalindrome(left + 1, right - 1, remaining)
        } else {
            return isPalindrome(left, right - 1, remaining - 1) || return isPalindrome(left + 1, right, remaining - 1)
        }
    }
    return isPalindrome(0, s.lastIndex, k)
}

private fun main() {

}
