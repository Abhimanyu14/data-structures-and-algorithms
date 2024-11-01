package leetcode.leetcode_2369_check_if_there_is_a_valid_partition_for_the_array

/**
 * leetcode - https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
 *
 * Using recursion and tabulation
 *
 * Stats
 * Runtime: 679 ms, faster than 7.54%
 * Memory Usage: 144.5 MB, less than 5.03%
 */
private fun validPartition(nums: IntArray): Boolean {
    val memo = mutableMapOf<Int, Boolean>()

    fun isValid(start: Int) : Boolean {
        memo[start]?.let {
            return it
        }
        if (start == nums.lastIndex) {
            return false
        }
        if (start > nums.lastIndex) {
            return true
        }
        val twoEqual = if (nums[start] == nums[start + 1]) {
            isValid(start + 2)
        } else {
            false
        }
        val threeEqual = if (((start + 2) <= nums.lastIndex) && (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2])) {
            isValid(start + 3)
        } else {
            false
        }
        val threeAscending = if (((start + 2) <= nums.lastIndex) && (nums[start + 1] == (nums[start] + 1) && nums[start + 2] == (nums[start + 1] + 1))) {
            isValid(start + 3)
        } else {
            false
        }
        memo[start] = twoEqual || threeEqual || threeAscending
        return memo[start] ?: false
    }
    return isValid(0)
}

private fun main() {

}
