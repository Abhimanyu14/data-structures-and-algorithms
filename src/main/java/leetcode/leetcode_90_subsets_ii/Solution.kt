package leetcode.leetcode_90_subsets_ii

/**
 * leetcode - https://leetcode.com/problems/subsets-ii/
 *
 * Data Structure - NA
 * Algorithm - Backtracking - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2^N)
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    fun backtrack(index: Int, current: MutableList<Int>) {
        if (index == nums.size) {
            result.add(current.sorted())
            return
        }
        backtrack(index + 1, current)
        current.add(nums[index])
        backtrack(index + 1, current)
        current.remove(nums[index])
    }
    backtrack(0, mutableListOf())
    return result.toList()
}

/**
 * leetcode - https://leetcode.com/problems/subsets-ii/
 *
 * Data Structure -
 * Algorithm - Generation - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun subsetsWithDupUsingGeneration(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    fun generate(index: Int, current: List<Int>) {
        if (index == nums.size) {
            result.add(current.sorted())
            return
        }
        generate(index + 1, current)
        generate(index + 1, current + nums[index])
    }
    generate(0, listOf())
    return result.toList()
}

private fun main() {

}
