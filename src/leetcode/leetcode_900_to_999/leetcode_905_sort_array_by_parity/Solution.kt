package leetcode.leetcode_900_to_999.leetcode_905_sort_array_by_parity

/**
 * leetcode - https://leetcode.com/problems/sort-array-by-parity/submissions/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 220 ms, faster than 43.66%
 * Memory Usage: 40.5 MB, less than 12.68%
 */
private fun sortArrayByParity(nums: IntArray): IntArray {
    var start = 0
    var end = nums.lastIndex
    while (start < end) {
        if (nums[start] % 2 == 0) {
            start++
        } else if (nums[end] % 2 == 1) {
            end--
        } else {
            nums[start] = nums[end].also {
                nums[end] = nums[start]
            }
            start++
            end--
        }
    }
    return nums
}

private fun main() {

}
