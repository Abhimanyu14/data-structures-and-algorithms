package leetcode.leetcode_163_missing_ranges

/**
 * leetcode - https://leetcode.com/problems/missing-ranges/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [List]
 * Algorithm - Iteration
 *
 * List methods - [first], [last]
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
    if (nums.isEmpty()) {
        return listOf(listOf(lower, upper))
    }
    if (nums.size == (upper - lower + 1)) {
        return emptyList()
    }
    val result = mutableListOf<List<Int>>()
    if (nums.first() > lower) {
        result.add(listOf(lower, nums.first() - 1))
    }
    for (i in 0..<nums.lastIndex) {
        if (nums[i + 1] - nums[i] > 1) {
            result.add(listOf(nums[i] + 1, nums[i + 1] - 1))
        }
    }
    if (nums.last() < upper) {
        result.add(listOf(nums.last() + 1, upper))
    }
    return result
}

private fun main() {

}
