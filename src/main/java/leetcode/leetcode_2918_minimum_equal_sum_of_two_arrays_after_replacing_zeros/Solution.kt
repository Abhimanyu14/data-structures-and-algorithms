package leetcode.leetcode_2918_minimum_equal_sum_of_two_arrays_after_replacing_zeros

/**
 * leetcode - https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/?envType=daily-question&envId=2025-05-10
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(m + n)
 * Space - O(1)
 *
 * Companies -
 */
private fun minSum(nums1: IntArray, nums2: IntArray): Long {
    var zeroCount1 = 0
    var zeroCount2 = 0
    var sum1 = 0L
    var sum2 = 0L
    for (num in nums1) {
        if (num == 0) {
            zeroCount1++
        } else {
            sum1 += num
        }
    }
    for (num in nums2) {
        if (num == 0) {
            zeroCount2++
        } else {
            sum2 += num
        }
    }
    return if (sum1 + zeroCount1 == sum2 + zeroCount2) {
        return sum1 + zeroCount1
    } else if (sum1 + zeroCount1 < sum2 + zeroCount2) {
        if (zeroCount1 > 0) {
            sum2 + zeroCount2
        } else {
            -1
        }
    } else {
        if (zeroCount2 > 0) {
            sum1 + zeroCount1
        } else {
            -1
        }
    }
}

private fun main() {

}
