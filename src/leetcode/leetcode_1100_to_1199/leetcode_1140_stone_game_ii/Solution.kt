package leetcode.leetcode_1100_to_1199.leetcode_1140_stone_game_ii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/stone-game-ii/?envType=daily-question&envId=2024-08-20
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun stoneGameII(piles: IntArray): Int {
    val length = piles.size
    val dp = Array(length + 1) { IntArray(length + 1) }

    // Store suffix sum for all possible suffix
    val suffixSum = IntArray(length + 1)
    for (i in length - 1 downTo 0) {
        suffixSum[i] = suffixSum[i + 1] + piles[i]
    }

    // Initialize the dp array.
    for (i in 0..length) {
        dp[i][length] = suffixSum[i]
    }

    // Start from the last index to store the future state first.
    for (index in length - 1 downTo 0) {
        for (maxTillNow in length - 1 downTo 1) {
            var X = 1
            while (X <= 2 * maxTillNow && index + X <= length
            ) {
                dp[index][maxTillNow] = max(
                    dp[index][maxTillNow].toDouble(),
                    (suffixSum[index] -
                            dp[index + X][max(maxTillNow.toDouble(), X.toDouble()).toInt()]).toDouble()
                ).toInt()
                X++
            }
        }
    }
    return dp[0][1]
}

private fun main() {

}
