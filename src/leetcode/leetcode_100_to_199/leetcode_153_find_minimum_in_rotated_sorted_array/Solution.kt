package leetcode.leetcode_100_to_199.leetcode_153_find_minimum_in_rotated_sorted_array

/**
 * leetcode - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Using divide and conquer
 *
 * Stats
 * Runtime: 302 ms, faster than 51.22%
 * Memory Usage: 37.4 MB, less than 44.60%
 */

// TODO-Abhi: Using iterative method
private fun findMin(nums: IntArray): Int {


    return divAndCon(nums, 0, nums.lastIndex)
}

private fun findMinRecursive(nums: IntArray): Int {
    return divAndCon(nums, 0, nums.lastIndex)
}

private fun divAndCon(nums: IntArray, first: Int, last: Int): Int {
    if (first == last || nums[first] < nums[last]) {
        return nums[first]
    }
    val mid = (first + last) / 2
    if (nums[first] < nums[mid]) {
        return divAndCon(nums, mid + 1, last)
    }
    return divAndCon(nums, first + 1, mid)
}

private fun main() {

}
