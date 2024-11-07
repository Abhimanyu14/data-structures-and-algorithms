package leetcode.leetcode_1863_sum_of_all_subset_xor_totals

/**
 * leetcode - https://leetcode.com/problems/sum-of-all-subset-xor-totals/?envType=daily-question&envId=2024-05-20
 *
 * Using recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 139 ms, faster than 45.45%
 * Memory Usage: 37 MB, less than 18.18%
 *
 * Time -
 * Space -
 */
private fun subsetXORSum(nums: IntArray): Int {
    fun getResult(index: Int, current: Int) : Int {
        if (index > nums.lastIndex) {
            return current
        }
        return getResult(index + 1, current) + getResult(index + 1, current xor nums[index])
    }
    return getResult(0, 0)
}

private fun main() {

}
