package leetcode.leetcode_162_find_peak_element

/**
 * leetcode - https://leetcode.com/problems/find-peak-element/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 16 ms, faster than 22.34%
 * Memory Usage: 39.6 MB, less than 5.64%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (mid == nums.lastIndex || nums[mid] > nums[mid + 1]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
