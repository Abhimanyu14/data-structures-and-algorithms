package leetcode.leet_1200_to_1299.leet_1269_number_of_ways_to_stay_in_the_same_place_after_some_steps

import java.util.Arrays
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 *
 * TODO(Abhi) - To revisit
 *
 * Using dynamic programming - Top down
 *
 * Stats
 * Runtime: 149 ms, faster than 87.50%
 * Memory Usage: 36.7 MB, less than 87.50%
 */
private fun numWays(steps: Int, arrLen: Int): Int {
    val mod = 1e9.toInt() + 7
    val newArrLen = min(arrLen, steps)
    val memo: Array<IntArray> = Array(newArrLen) { IntArray(steps + 1) }

    fun dp(curr: Int, remain: Int): Int {
        if (remain == 0) {
            return if (curr == 0) {
                1
            } else {
                0
            }
        }
        if (memo[curr][remain] != -1) {
            return memo[curr][remain]
        }
        var ans = dp(curr, remain - 1)
        if (curr > 0) {
            ans = (ans + dp(curr - 1, remain - 1)) % mod
        }
        if (curr < newArrLen - 1) {
            ans = (ans + dp(curr + 1, remain - 1)) % mod
        }
        memo[curr][remain] = ans
        return ans
    }
    for (row in memo) {
        Arrays.fill(row, -1)
    }
    return dp(0, steps)
}

private fun main() {

}
