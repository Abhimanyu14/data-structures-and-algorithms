package leetcode.leet_100_to_199.leet_152_maximum_product_subarray

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-product-subarray/
 *
 * Using single pass
 *
 * Stats
 * Runtime: 179 ms, faster than 65.32%
 * Memory Usage: 37.4 MB, less than 84.97%
 */
private fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var maxSoFar = nums[0]
    var minSoFar = nums[0]
    var result = maxSoFar
    for (i in 1..nums.lastIndex) {
        val tempMax = max(nums[i], max((maxSoFar * nums[i]), (minSoFar * nums[i])))
        minSoFar = min(nums[i], min((maxSoFar * nums[i]), (minSoFar * nums[i])))
        maxSoFar = tempMax
        result = max(result, maxSoFar)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-product-subarray/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 530 ms, faster than 7.52%
 * Memory Usage: 39.6 MB, less than 14.45%
 */
private fun maxProductBruteForce(nums: IntArray): Int {
    var result = nums[0]
    var current: Int
    for (i in 0..nums.lastIndex) {
        current = 1
        for (j in i..nums.lastIndex) {
            current *= nums[j]
            result = max(result, current)
        }
    }
    return result
}

private fun main() {

}
