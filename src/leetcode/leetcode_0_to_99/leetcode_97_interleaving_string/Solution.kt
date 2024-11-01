package leetcode.leetcode_0_to_99.leetcode_97_interleaving_string

/**
 * leetcode - https://leetcode.com/problems/interleaving-string/
 * Using dynamic programming
 *
 * TODO-Abhi: Understand the implementation
 * Stats
 * Runtime: 349 ms, faster than 19.05%
 * Memory Usage: 40.5 MB, less than 19.05%
 */
private fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s3.length != (s1.length + s2.length) ||
        s3.split("").sorted() != (s1 + s2).split("").sorted()
    ) {
        return false
    }
    val dp = BooleanArray(s2.length + 1)
    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            println("i: $i j: $j dp: ${dp.joinToString(", ")}")
            if (i == 0 && j == 0) {
                dp[j] = true
            } else if (i == 0) {
                dp[j] = dp[j - 1] && s2[j - 1] == s3[i + j - 1]
            } else if (j == 0) {
                dp[j] = dp[j] && s1[i - 1] == s3[i + j - 1]
            } else {
                dp[j] = (dp[j] && s1[i - 1] == s3[i + j - 1]) || (dp[j - 1] && s2[j - 1] == s3[i + j - 1])
            }
        }
        println()
    }
    return dp[s2.length]
}

private fun main() {

}
