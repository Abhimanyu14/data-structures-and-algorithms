package leetcode.leet_600_to_699.leet_680_valid_palindrome_ii

/**
 * leetcode - https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 264 ms, faster than 49.49%
 * Memory Usage: 39.3 MB, less than 16.33%
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
