package leetcode.leetcode_647_palindromic_substrings

/**
 * leetcode - https://leetcode.com/problems/palindromic-substrings/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun countSubstrings(s: String): Int {
    fun getCount(left: Int, right: Int): Int {
        if (left < 0 || right > s.lastIndex) {
            return 0
        }
        if (s[left] != s[right]) {
            return 0
        }
        return 1 + getCount(left - 1, right + 1)
    }
    var result = 0
    for (i in 0..<s.lastIndex) {
        result += getCount(i, i)
        result += getCount(i, i + 1)
    }
    result += getCount(s.lastIndex, s.lastIndex)
    return result
}

private fun main() {

}
