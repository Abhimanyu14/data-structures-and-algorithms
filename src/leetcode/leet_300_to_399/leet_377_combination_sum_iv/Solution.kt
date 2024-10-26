package leetcode.leet_300_to_399.leet_377_combination_sum_iv

/**
 * leetcode - https://leetcode.com/problems/combination-sum-iv/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 * Runtime: 140 ms, faster than 72.34%
 * Memory Usage: 33.7 MB, less than 61.70%
 */
private fun combinationSum4(nums: IntArray, target: Int): Int {
    val sorted = nums.sorted()
    val dp = IntArray(target + 1)
    dp[0] = 1

    for (currentSum in 1..target) {
        for (num in sorted) {
            if (currentSum - num >= 0) {
                dp[currentSum] += dp[currentSum - num]
            } else {
                break
            }
        }
    }
    return dp[target]
}

private fun main() {
    println(combinationSum4(intArrayOf(1, 2, 3), 4))
}
