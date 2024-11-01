package leetcode.leetcode_100_to_199.leetcode_162_find_peak_element

/**
 * leetcode - https://leetcode.com/problems/find-peak-element/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 202 ms, faster than 83.08%
 * Memory Usage: 37.2 MB, less than 60.77%
 */
private fun findPeakElement(nums: IntArray): Int {
    var start = 0
    var end = nums.lastIndex
    var mid: Int
    while (start < end) {
        mid = (start + end) / 2
        if (nums[mid] < nums[mid + 1]) {
            start = mid + 1
        } else {
            end = mid
        }
    }
    return start
}

private fun main() {

}
