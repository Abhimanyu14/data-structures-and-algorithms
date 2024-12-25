package leetcode.leetcode_3392_count_subarrays_of_length_three_with_a_condition

/**
 * leetcode - https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 25.00%
 * Memory Usage: 44.7 MB, less than 21.43%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun countSubarrays(nums: IntArray): Int {
    var result = 0
    for (i in 1..(nums.lastIndex - 1)) {
        if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
            result++
        }
    }
    return result
}

private fun main() {

}
