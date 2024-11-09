package leetcode.leetcode_1389_create_target_array_in_the_given_order

/**
 * leetcode - https://leetcode.com/problems/create-target-array-in-the-given-order/description/
 *
 * Using [add]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 7 ms, faster than 100.00%
 * Memory Usage: 35.9 MB, less than 30.00%
 *
 * Time -
 * Space -
 */
private fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
    val result = mutableListOf<Int>()
    for (i in nums.indices) {
        result.add(index[i], nums[i])
    }
    return result.toIntArray()
}

private fun main() {

}
