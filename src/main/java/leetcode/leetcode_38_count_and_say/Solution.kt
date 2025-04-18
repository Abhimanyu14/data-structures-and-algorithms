package leetcode.leetcode_38_count_and_say

/**
 * leetcode - https://leetcode.com/problems/count-and-say/
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    }
    fun rle(s: String): String {
        val result = StringBuilder()
        var prevChar = s[0]
        var prevCharCount = 1
        for (i in 1..s.lastIndex) {
            if (s[i] == prevChar) {
                prevCharCount++
            } else {
                result.append("${prevCharCount}${prevChar}")
                prevChar = s[i]
                prevCharCount = 1
            }
        }
        result.append("${prevCharCount}${prevChar}")
        return result.toString()
    }
    return rle(countAndSay(n - 1))
}

private fun countAndSayUsingDp(n: Int): String {
    val dp = Array(n + 1) { "" }
    dp[1] = "1"

    fun rle(s: String): String {
        val result = StringBuilder()
        var prevChar = s[0]
        var prevCharCount = 1
        for (i in 1..s.lastIndex) {
            if (s[i] == prevChar) {
                prevCharCount++
            } else {
                result.append("${prevCharCount}${prevChar}")
                prevChar = s[i]
                prevCharCount = 1
            }
        }
        result.append("${prevCharCount}${prevChar}")
        return result.toString()
    }
    for (i in 2..n) {
        dp[i] = rle(dp[i - 1])
    }
    return dp[n]
}


private fun main() {
    val input1 = 1
    val input2 = 4
    for (i in 1..10) {
        println(countAndSayUsingDp(i))
    }
//    println(countAndSay(input2))
}
