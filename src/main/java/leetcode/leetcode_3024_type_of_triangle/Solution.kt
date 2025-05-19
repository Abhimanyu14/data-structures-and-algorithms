package leetcode.leetcode_3024_type_of_triangle

/**
 * leetcode - https://leetcode.com/problems/type-of-triangle/
 *
 * Data Structure - NA
 * Algorithm - Maths - Triangle rules
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 31.92 MB, less than 100.00%
 *
 * Time - O(1)
 * Space - O(1)
 *
 * Companies - Google, Microsoft
 */
private fun triangleType(nums: IntArray): String {
    if (nums[0] == nums[1] && nums[0] == nums[2]) {
        return "equilateral"
    }
    if ((nums[0] >= nums[1] + nums[2]) || (nums[1] >= nums[0] + nums[2]) || (nums[2] >= nums[1] + nums[0])) {
        return "none"
    }
    if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
        return "isosceles"
    }
    return "scalene"
}

private fun main() {

}
