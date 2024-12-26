package leetcode.leetcode_494_target_sum

/**
 * leetcode - https://leetcode.com/problems/target-sum/
 *
 * Data Structure - Map
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 76 ms, faster than 65.93%
 * Memory Usage: 41.7 MB, less than 28.57%
 *
 * Time -
 * Space -
 */
private fun findTargetSumWays(nums: IntArray, target: Int): Int {
    var dp = mutableMapOf<Int, Int>()
    dp[0] = 1
    for (num in nums) {
        val map = mutableMapOf<Int, Int>()
        for ((prevSum, count) in dp) {
            map[prevSum + num] = map.getOrDefault(prevSum + num, 0) + count
            map[prevSum - num] = map.getOrDefault(prevSum - num, 0) + count
        }
        dp = map
    }
    return dp.getOrDefault(target, 0)
}

/**
 * leetcode - https://leetcode.com/problems/target-sum/
 *
 * Data Structure - Array
 * Algorithm - Dynamic Programming - Recursion with memoization
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 149 ms, faster than 41.76%
 * Memory Usage: 48.8 MB, less than 7.69%
 *
 * Time - O(2 ^ N)
 * Space - O(N)
 */
private fun findTargetSumWaysUsingRecursionWithMemoization(nums: IntArray, target: Int): Int {
    val memo = mutableMapOf<Pair<Int, Int>, Int>()
    fun evaluate(index: Int, current: Int): Int {
        memo[Pair(index, current)]?.let {
            return it
        }
        if (index == nums.size) {
            if (current == target) {
                memo[Pair(index, current)] = 1
                return 1
            }
            memo[Pair(index, current)] = 0
            return 0
        }
        memo[Pair(index, current)] = evaluate(index + 1, current + nums[index]) +
                evaluate(index + 1, current - nums[index])
        return memo.getOrDefault(Pair(index, current), 0)
    }
    return evaluate(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/target-sum/
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 392 ms, faster than 13.19%
 * Memory Usage: 35.4 MB, less than 76.92%
 *
 * Time - O(2 ^ N)
 * Space - O(N)
 */
private fun findTargetSumWaysUsingRecursion(nums: IntArray, target: Int): Int {
    var result = 0
    fun evaluate(index: Int, current: Int) {
        if (index == nums.size) {
            if (current == target) {
                result++
            }
            return
        }
        evaluate(index + 1, current + nums[index])
        evaluate(index + 1, current - nums[index])
    }
    evaluate(0, 0)
    return result
}

private fun main() {

}
