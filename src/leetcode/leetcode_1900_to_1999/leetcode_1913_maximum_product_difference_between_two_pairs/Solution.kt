package leetcode.leetcode_1900_to_1999.leetcode_1913_maximum_product_difference_between_two_pairs

/**
 * leetcode - https://leetcode.com/problems/maximum-product-difference-between-two-pairs/?envType=daily-question&envId=2023-12-18
 *
 * Using sorting
 *
 * Stats
 * Runtime: 264 ms, faster than 20.00%
 * Memory Usage: 40.1 MB, less than 56.00%
 */
private fun maxProductDifference(nums: IntArray): Int {
    nums.sort()
    return (nums[nums.lastIndex] * nums[nums.lastIndex - 1]) - (nums[0] * nums[1])
}

private fun main() {

}
