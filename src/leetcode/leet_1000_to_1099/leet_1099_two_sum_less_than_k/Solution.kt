package leetcode.leet_1000_to_1099.leet_1099_two_sum_less_than_k

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/two-sum-less-than-k/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 202 ms, faster than 86.96%
 * Memory Usage: 35.9 MB, less than 72.46%
 */
private fun twoSumLessThanKBruteForce(nums: IntArray, k: Int): Int {
    var result = -1
    var sum: Int
    nums.forEachIndexed { index, _ ->
        for (i in (index + 1)..nums.lastIndex) {
            sum = nums[index] + nums[i]
            if (sum in (result + 1) until k) {
                result = sum
            }
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/two-sum-less-than-k/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 202 ms, faster than 86.96%
 * Memory Usage: 35.9 MB, less than 72.46%
 */
private fun twoSumLessThanK(nums: IntArray, k: Int): Int {
    nums.sorted()
    var low = 0
    var high = nums.lastIndex
    var result = -1
    var sum: Int
    while (low < high) {
        sum = nums[low] + nums[high]
        if (sum >= k) {
            high--
        } else {
            result = max(result, sum)
            low++
        }
    }
    return result
}

private fun main() {

}
