package leetcode.leetcode_80_remove_duplicates_from_sorted_array_ii

/**
 * leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun removeDuplicates(nums: IntArray): Int {
    var insertIndex = 1
    var prevNum = nums[0]
    var prevCount = 1
    for (i in 1..nums.lastIndex) {
        if (nums[i] == prevNum) {
            prevCount++
            if (prevCount == 2) {
                nums[insertIndex] = nums[i]
                insertIndex++
            }
        } else {
            nums[insertIndex] = nums[i]
            insertIndex++
            prevCount = 1
            prevNum = nums[i]
        }
    }
    return insertIndex
}

private fun removeDuplicatesWithBoolean(nums: IntArray): Int {
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
