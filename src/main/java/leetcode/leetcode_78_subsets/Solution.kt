package leetcode.leetcode_78_subsets

/**
 * leetcode - https://leetcode.com/problems/subsets/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 164 ms, faster than 96.49%
 * Memory Usage: 37.2 MB, less than 49.12%
 *
 * Time - O(2^N)
 * Space - O(2^N)
 *
 * Companies - Meta
 */
private fun subsetsUsingIteration(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    result.add(emptyList())
    for (num in nums) {
        val newSubsets = mutableListOf<List<Int>>()
        for (subset in result) {
            newSubsets.add(subset + num)
        }
        result.addAll(newSubsets)
    }
    return result
}

private fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun generateSet(currentList: List<Int>, currentPos: Int) {
        if (currentPos == nums.size) {
            result.add(currentList)
            return
        }
        generateSet(currentList, currentPos + 1)
        generateSet(currentList + nums[currentPos], currentPos + 1)
    }
    generateSet(mutableListOf(), 0)
    return result.distinct()
}

private fun main() {

}
