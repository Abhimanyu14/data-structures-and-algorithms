package leetcode.leetcode_26_remove_duplicates_from_sorted_array

/**
 * leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Stats
 * Runtime: 440 ms, faster than 53.51%
 * Memory Usage: 47 MB, less than 33.05%
 */
fun removeDuplicates(nums: IntArray): Int {
    var result = 1
    for (i in 1..nums.lastIndex) {
        if (nums[result - 1] != nums[i]) {
            nums[result] = nums[i]
            result++
        }
    }
    return result
}

private fun main() {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}
