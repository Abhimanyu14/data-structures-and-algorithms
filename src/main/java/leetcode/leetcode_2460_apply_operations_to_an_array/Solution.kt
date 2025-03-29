package leetcode.leetcode_2460_apply_operations_to_an_array

/**
 * leetcode - https://leetcode.com/problems/apply-operations-to-an-array/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - NA
 *
 * Companies - Meta
 */
private fun applyOperations(nums: IntArray): IntArray {
    var index = 0
    for (i in 0..<nums.lastIndex) {
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
        if (nums[i] != 0) {
            nums[index++] = nums[i]
        }
    }
    if (nums.last() != 0) {
        nums[index++] = nums.last()
    }
    while (index <= nums.lastIndex) {
        nums[index] = 0
        index++
    }
    return nums
}

private fun main() {

}
