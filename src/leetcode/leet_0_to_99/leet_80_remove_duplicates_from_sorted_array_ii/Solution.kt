package leetcode.leet_0_to_99.leet_80_remove_duplicates_from_sorted_array_ii

/**
 * leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Using loop
 *
 * Stats
 * Runtime: 210 ms, faster than 20.69%
 * Memory Usage: 38.2 MB, less than 6.68%
 */
private fun removeDuplicates(nums: IntArray): Int {
    var result = 1
    var duplicate = false
    for (i in 1..nums.lastIndex) {
        if (nums[result - 1] == nums[i]) {
            if (duplicate) {
                continue
            } else {
                duplicate = true
                nums[result] = nums[i]
                result++
            }
        } else {
            duplicate = false
            nums[result] = nums[i]
            result++
        }
    }
    return result
}

private fun main() {

}
