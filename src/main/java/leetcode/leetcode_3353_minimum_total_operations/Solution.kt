package leetcode.leetcode_3353_minimum_total_operations

/**
 * leetcode - https://leetcode.com/problems/minimum-total-operations/
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies -
 */
private fun minOperations(nums: IntArray): Int {
    var result = 0
    for (i in (nums.lastIndex - 1) downTo 0) {
        if (nums[i] != nums[i + 1]) {
            result++
        }
    }
    return result
}

private fun main() {

}
