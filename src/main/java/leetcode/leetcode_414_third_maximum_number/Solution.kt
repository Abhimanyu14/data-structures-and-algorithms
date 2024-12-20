package leetcode.leetcode_414_third_maximum_number

/**
 * leetcode - https://leetcode.com/problems/third-maximum-number/
 *
 * Data Structure - Three Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 55.70%
 * Memory Usage: 39 MB, less than 46.84%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun thirdMax(nums: IntArray): Int {
    var first: Int = nums[0]
    var second: Int? = null
    var third: Int? = null
    for (i in 1..nums.lastIndex) {
        if (nums[i] > first) {
            third = second
            second = first
            first = nums[i]
        } else if (nums[i] == first) {

        } else if (second == null || nums[i] > second) {
            third = second
            second = nums[i]
        } else if (nums[i] == second) {

        } else if (third == null || nums[i] > third) {
            third = nums[i]
        }
    }
    return third ?: first
}

private fun main() {

}
