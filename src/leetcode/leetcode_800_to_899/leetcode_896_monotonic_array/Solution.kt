package leetcode.leetcode_800_to_899.leetcode_896_monotonic_array

/**
 * leetcode - https://leetcode.com/problems/monotonic-array/
 *
 * Using single pass
 *
 * Stats
 * Runtime: 536 ms, faster than 65.85%
 * Memory Usage: 58 MB, less than 80.49%
 */
private fun isMonotonic(nums: IntArray): Boolean {
    if (nums.size <= 1) {
        return true
    }
    var i = 0

    // Skip all initial equal numbers
    while (i < nums.lastIndex && nums[i] == nums[i + 1]) {
        i++
    }
    if (i == nums.lastIndex) {
        return true
    }

    val isIncreasing = nums[i] < nums[i + 1]
    while (i < nums.lastIndex) {
        if ((isIncreasing && nums[i] > nums[i + 1]) || (!isIncreasing && nums[i] < nums[i + 1])) {
            return false
        }
        i++
    }
    return true
}

private fun main() {

}
