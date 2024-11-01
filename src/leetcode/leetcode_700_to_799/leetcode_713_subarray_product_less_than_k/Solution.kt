package leetcode.leetcode_700_to_799.leetcode_713_subarray_product_less_than_k

/**
 * leetcode - https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * TODO(Abhi): To revisit
 *
 * Using sliding window
 *
 * Stats
 */
private fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    // Handle edge cases where k is 0 or 1 (no subarrays possible)
    if (k <= 1) {
        return 0
    }

    var result = 0
    var product = 1

    // Use two pointers to maintain a sliding window
    var left = 0
    var right = 0
    while (right < nums.size) {
        // Expand the window by including the element at the right pointer
        product *= nums[right]

        // Shrink the window from the left while the product is greater than or equal to k
        while (product >= k) {
            // Remove the element at the left pointer from the product
            product /= nums[left++]
        }

        // Update the total count by adding the number of valid subarrays with the current window size
        result += right - left + 1 // right - left + 1 represents the current window size
        right++
    }

    return result
}

/**
 * leetcode - https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 1281 ms, faster than 5.17%
 * Memory Usage: 41 MB, less than 98.28%
 *
 * Time - O(N^2)
 * Space - O(1)
 */
private fun numSubarrayProductLessThanKUsingBruteForce(nums: IntArray, k: Int): Int {
    var result = 0
    var current: Long
    for (i in nums.indices) {
        current = nums[i].toLong()
        if (current < k) {
            result++
            for (j in (i + 1)..nums.lastIndex) {
                current *= nums[j]
                if (current < k) {
                    result++
                } else {
                    break
                }
            }
        }
    }
    return result
}

private fun main() {

}
