package leetcode.leetcode_628_maximum_product_of_three_numbers

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * Using
 *
 * Stats
 * Runtime: 302 ms, faster than 92.11%
 * Memory Usage: 39.4 MB, less than 73.68%
 */
fun maximumProduct(nums: IntArray): Int {
    var min1 = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    var max3 = Int.MIN_VALUE
    for (n in nums) {
        if (n <= min1) {
            min2 = min1
            min1 = n
        } else if (n <= min2) {     // n lies between min1 and min2
            min2 = n
        }
        if (n >= max1) {            // n is greater than max1, max2 and max3
            max3 = max2
            max2 = max1
            max1 = n
        } else if (n >= max2) {     // n lies between max1 and max2
            max3 = max2
            max2 = n
        } else if (n >= max3) {     // n lies between max2 and max3
            max3 = n
        }
    }
    return max(min1 * min2 * max1, max1 * max2 * max3)
}

/**
 * leetcode - https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * Using
 *
 * Stats
 * Time Limit Exceeded
 */
private fun maximumProductBruteForce(nums: IntArray): Int {
    var result = Integer.MIN_VALUE
    for (i in nums.indices) {
        for (j in nums.indices) {
            for (k in nums.indices) {
                if (i != j && j != k && i != k) {
                    result = max(result, nums[i] * nums[j] * nums[k])
                }
            }
        }
    }
    return result
}

private fun main() {

}
