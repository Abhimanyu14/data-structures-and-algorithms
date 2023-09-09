package leetcode.leet_1100_to_1199.leet_1150_check_if_a_number_is_majority_element_in_a_sorted_array

/**
 * leetcode - https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Stats
 * Runtime: 167 ms, faster than 100.00%
 * Memory Usage: 36.7 MB, less than 50.00%
 */
private fun isMajorityElement(nums: IntArray, target: Int): Boolean {
    return nums.count { it == target } > (nums.size / 2)
}

private fun main() {

}
