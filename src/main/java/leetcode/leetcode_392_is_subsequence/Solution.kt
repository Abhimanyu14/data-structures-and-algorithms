package leetcode.leetcode_392_is_subsequence

/**
 * leetcode - https://leetcode.com/problems/is-subsequence/
 * https://leetcode.com/problems/is-subsequence/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 99.06%
 * Memory Usage: 35.3 MB, less than 19.07%
 *
 * Time - O(m + n)
 * Space - O(1)
 *
 * Companies - Google, Meta
*/
private fun isSubsequence(s: String, t: String): Boolean {
    var sIndex = 0
    var tIndex = 0
    while (sIndex <= s.lastIndex && tIndex <= t.lastIndex) {
        if (s[sIndex] == t[tIndex]) {
            sIndex++
        }
        tIndex++
    }
    return sIndex == s.length
}

private fun isSubsequenceUsingForLoop(s: String, t: String): Boolean {
    if (s.isEmpty()) {
        return true
    }
    var sIndex = 0
    for (tIndex in t.indices) {
        if (t[tIndex] == s[sIndex]) {
            sIndex++
            if (sIndex == s.length) {
                return true
            }
        }
    }
    return sIndex == s.length
}

/**
 * leetcode - https://leetcode.com/problems/is-subsequence/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 131 ms, faster than 68.55%
 * Memory Usage: 34 MB, less than 43.97%
 */
private fun isSubsequenceUsingTwoPointers(s: String, t: String): Boolean {
    var i = 0
    var j = 0
    while (i < s.length && j < t.length) {
        if (s[i] == t[j]) {
            i++
        }
        j++
    }
    return i == s.length
}

private fun main() {
}
