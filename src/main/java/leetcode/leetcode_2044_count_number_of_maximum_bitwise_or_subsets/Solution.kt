package leetcode.leetcode_2044_count_number_of_maximum_bitwise_or_subsets

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/?envType=daily-question&envId=2025-07-28
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2 ^ N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun countMaxOrSubsets(nums: IntArray): Int {
    var maxValue = 0
    for (num in nums) {
        maxValue = maxValue or num
    }
    fun getOrValue(index: Int, current: Int): Int {
        if (current == maxValue) {
            return (2.0).pow(nums.size - index).toInt()
        }
        if (index == nums.size) {
            return 0
        }
        return getOrValue(index + 1, current) + getOrValue(index + 1, current or nums[index])
    }
    return getOrValue(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/?envType=daily-question&envId=2025-07-28
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2 ^ N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun countMaxOrSubsetsReturningValue(nums: IntArray): Int {
    var maxValue = 0
    for (num in nums) {
        maxValue = maxValue or num
    }
    fun getOrValue(index: Int, current: Int): Int {
        if (index == nums.size) {
            if (current == maxValue) {
                return 1
            }
            return 0
        }
        return getOrValue(index + 1, current) + getOrValue(index + 1, current or nums[index])
    }
    return getOrValue(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/?envType=daily-question&envId=2025-07-28
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2 ^ N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun countMaxOrSubsetsUsingRecursion(nums: IntArray): Int {
    var result = 0
    var maxValue = 0
    for (num in nums) {
        maxValue = maxValue or num
    }
    fun getOrValue(index: Int, current: Int) {
        if (index == nums.size) {
            if (current == maxValue) {
                result++
            }
            return
        }
        getOrValue(index + 1, current)
        getOrValue(index + 1, current or nums[index])
    }
    getOrValue(0, 0)
    return result
}

private fun main() {

}
