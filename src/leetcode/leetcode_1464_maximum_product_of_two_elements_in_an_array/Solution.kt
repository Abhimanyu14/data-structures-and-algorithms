package leetcode.leetcode_1464_maximum_product_of_two_elements_in_an_array

/**
 * leetcode - https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * Using iteration - two pointers
 *
 * Stats
 * Runtime: 173 ms, faster than 61.22%
 * Memory Usage: 37.7 MB, less than 34.69%
 */
private fun maxProduct(nums: IntArray): Int {
    var largest: Int
    var next: Int
    if (nums[0] > nums[1]) {
        largest = nums[0]
        next = nums[1]
    } else {
        largest = nums[1]
        next = nums[0]
    }
    for (i in 2..nums.lastIndex) {
        if (nums[i] > largest) {
            next = largest
            largest = nums[i]
        } else if (nums[i] > next) {
            next = nums[i]
        }
    }
    return (largest - 1) * (next - 1)
}

private fun main() {

}
