package leetcode.leetcode_1600_to_1699.leetcode_1685_sum_of_absolute_differences_in_a_sorted_array

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 *
 * Using prefix sum
 *
 * Stats
 * Runtime: 584 ms, faster than 100.00%
 * Memory Usage: 54.1 MB, less than 50.00%
 */
private fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val totalSum = nums.sum()
    var leftSum = 0
    nums.forEachIndexed { i, num ->
        val rightSum = totalSum - leftSum - num
        val rightCount = nums.lastIndex - i
        val leftTotal = i * num - leftSum
        val rightTotal = rightSum - rightCount * num
        result[i] = leftTotal + rightTotal
        leftSum += num
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 *
 * Using prefix sum
 *
 * Stats
 * Runtime: 574 ms, faster than 100.00%
 * Memory Usage: 53.6 MB, less than 50.00%
 */
private fun getSumAbsoluteDifferencesWithPrefix(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val prefix = IntArray(nums.size)
    prefix[0] = nums[0]
    for (i in 1 until nums.size) {
        prefix[i] = prefix[i - 1] + nums[i]
    }
    nums.forEachIndexed { i, num ->
        val leftSum = prefix[i] - num
        val rightSum = prefix[nums.lastIndex] - prefix[i]
        val rightCount = nums.lastIndex - i
        val leftTotal = (i * num) - leftSum
        val rightTotal = rightSum - (rightCount * num)
        result[i] = leftTotal + rightTotal
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 *
 * Using brute force with memoization
 *
 * Stats
 * Runtime: 3472 ms, faster than 100.00%
 * Memory Usage: 54 MB, less than 50.00%
 */
private fun getSumAbsoluteDifferencesUsingMemoization(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val memo = mutableMapOf<Int, Int>()
    nums.forEachIndexed { i, num1 ->
        if (memo[num1] != null) {
            result[i] = memo[num1] ?: 0
        } else {
            nums.forEach { num2 ->
                result[i] += abs(num1 - num2)
            }
            memo[num1] = result[i]
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 *
 * Using brute force
 *
 * Stats
 * Time Limit Exceeded
 */
private fun getSumAbsoluteDifferencesUsingBruteForce(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    nums.forEach { num1 ->
        nums.forEachIndexed { i, num2 ->
            result[i] += abs(num1 - num2)
        }
    }
    return result
}

private fun main() {

}
