package leetcode.leetcode_1458_max_dot_product_of_two_subsequences

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Top down dynamic programming
 *
 * Stats
 * Runtime: 192 ms, faster than 100.00%
 * Memory Usage: 36.2 MB, less than 100.00%
 */
private fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
    var firstMax = Int.MIN_VALUE
    var secondMax = Int.MIN_VALUE
    var firstMin = Int.MAX_VALUE
    var secondMin = Int.MAX_VALUE

    val memo = Array(nums1.size) { IntArray(nums2.size) }
    fun dp(i: Int, j: Int, nums1: IntArray, nums2: IntArray): Int {
        if (i == nums1.size || j == nums2.size) {
            return 0
        }
        if (memo[i][j] != 0) {
            return memo[i][j]
        }
        val use = nums1[i] * nums2[j] + dp(i + 1, j + 1, nums1, nums2)
        memo[i][j] = max(use, max(dp(i + 1, j, nums1, nums2), dp(i, j + 1, nums1, nums2)))
        return memo[i][j]
    }

    for (num in nums1) {
        firstMax = max(firstMax, num)
        firstMin = min(firstMin, num)
    }
    for (num in nums2) {
        secondMax = max(secondMax, num)
        secondMin = min(secondMin, num)
    }
    if (firstMax < 0 && secondMin > 0) {
        return firstMax * secondMin
    }
    if (firstMin > 0 && secondMax < 0) {
        return firstMin * secondMax
    }

    return dp(0, 0, nums1, nums2)
}

private fun main() {

}
