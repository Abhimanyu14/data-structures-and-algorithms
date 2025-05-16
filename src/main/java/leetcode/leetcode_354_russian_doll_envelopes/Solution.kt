package leetcode.leetcode_354_russian_doll_envelopes

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/russian-doll-envelopes/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    var result = 1
    val sortedEnvelopes = envelopes.sortedWith(compareBy({ it[0] }, { it[1] }))
    val dp = IntArray(envelopes.size) { 1 }
    fun canContain(large: IntArray, small: IntArray): Boolean {
        return large[0] > small[0] && large[1] > small[1]
    }
    for (i in 1..sortedEnvelopes.lastIndex) {
        for (j in (i - 1) downTo 0) {
            if (canContain(sortedEnvelopes[i], sortedEnvelopes[j])) {
                dp[i] = max(dp[i], dp[j] + 1)
                result = max(result, dp[i])
                break
            }
        }
        println("$i dp: ${dp.joinToString(", ")}")
    }
    return result
}

private fun main() {

}
