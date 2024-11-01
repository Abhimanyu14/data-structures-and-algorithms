package leetcode.leetcode_1155_number_of_dice_rolls_with_target_sum

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/?envType=daily-question&envId=2023-12-26
 *
 * TODO(Abhi) - To revisit
 * Source - https://algo.monster/liteproblems/1155
 *
 * Using
 *
 * Stats
 * Runtime: 148 ms, faster than 85.00%
 * Memory Usage: 34.6 MB, less than 75.00%
 */
private fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val MODULO = 1e9.toInt() + 7 // Define the modulo to prevent integer overflow
    var dp = IntArray(target + 1) // dp array to store the number of ways to achieve each sum
    dp[0] = 1 // Base case: there's 1 way to achieve sum 0 - no dice rolled

    // Loop through each dice
    for (diceCount in 1..n) {
        val tempDp = IntArray(target + 1) // Temporary array for the current number of dices

        // Calculate number of ways for each sum value possible with the current number of dices
        for (currentSum in 1..min(target.toDouble(), (diceCount * k).toDouble()).toInt()) {

            // Go through each face value of the dice and accumulate ways to achieve 'currentSum'
            for (faceValue in 1..min(currentSum.toDouble(), k.toDouble()).toInt()) {
                tempDp[currentSum] = (tempDp[currentSum] + dp[currentSum - faceValue]) % MODULO
            }
        }

        // Update the dp array with the current number of dices' results
        dp = tempDp
    }

    // Return the number of ways to achieve the 'target' sum with 'n' dices
    return dp[target]
}

private fun main() {

}
