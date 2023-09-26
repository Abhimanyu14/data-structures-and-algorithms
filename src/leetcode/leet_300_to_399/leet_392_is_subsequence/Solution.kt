package leetcode.leet_300_to_399.leet_392_is_subsequence

/**
 * leetcode - https://leetcode.com/problems/is-subsequence/
 *
 * Using
 *
 * Stats
 *
 */
fun memoryEfficientIsSubsequence(s: String, t: String): Boolean {
    var i = 0
    t.forEach {
        if (i == s.length) {
            return true
        }
        if (it == s[i]) {
            i++
        }
    }
    return i == s.length
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
fun isSubsequence(s: String, t: String): Boolean {
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
    val inputS1 = "abc"
    val inputT1 = "ahbgdc"
    val inputS2 = "axc"
    val inputT2 = "ahbgdc"
    println(isSubsequence(inputS1, inputT1))
    println(isSubsequence(inputS2, inputT2))
}
