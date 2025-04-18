package leetcode.leetcode_38_count_and_say

/**
 * leetcode - https://leetcode.com/problems/count-and-say/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
fun generateValue(s: String): String {
    var result = ""
    var count = 1
    var char: Char = s[0]
    for (i in 1..<s.length) {
        if (char != s[i]) {
            result += count.toString() + char
            count = 1
            char = s[i]
        } else {
            count++
        }
    }
    result += count.toString() + char
    return result
}

// tabulation
fun countAndSay(n: Int): String {
    val dp = Array(n + 1) { "" }
    dp[1] = "1"
    for (i in 2..n) {
        dp[i] = generateValue(dp[i - 1])
    }
    return dp[n]
}

private fun main() {
    val input1 = 1
    val input2 = 4
    for (i in 1..10) {
        println(countAndSay(i))
    }
//    println(countAndSay(input2))
}
