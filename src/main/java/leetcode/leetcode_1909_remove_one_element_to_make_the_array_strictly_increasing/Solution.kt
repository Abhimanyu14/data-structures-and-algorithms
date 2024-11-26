package leetcode.leetcode_1909_remove_one_element_to_make_the_array_strictly_increasing

/**
 * leetcode - https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 100.00%
 * Memory Usage: 38.8 MB, less than 25.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun canBeIncreasing(nums: IntArray): Boolean {
    var prev = nums[0]
    var removed = false
    for (i in 1..nums.lastIndex) {
        if (nums[i] > prev) {
            prev = nums[i]
        } else {
            if (removed) {
                return false
            } else if (i == nums.lastIndex) {
                return true
            } else {
                removed = true
                if (i == 1 || nums[i] > nums[i - 2]) {
                    prev = nums[i]
                }
            }
        }
    }
    return true
}

private fun main() {

}
