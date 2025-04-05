package leetcode.leetcode_139_word_break

/**
 * leetcode - https://leetcode.com/problems/word-break/?envType=problem-list-v2&envId=hash-table&
 *
 * TODO(Abhi) - To revisit
 *
 * Using brute force
 *
 * Source - https://youtu.be/Sx9NNgInc3A?si=MtkbbHo1Ts-1ibcL
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 13 ms, faster than 59.26%
 * Memory Usage: 37.5 MB, less than 40.79%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1) { false }
    dp[s.length] = true
    for (i in s.lastIndex downTo 0) {
        for (word in wordDict) {
            if ((i + word.length <= s.length) && (s.substring(i, i + word.length) == word) && dp[i + word.length]) {
                dp[i] = true
                break
            }
        }
    }
    return dp[0]
}

private fun main() {

}
