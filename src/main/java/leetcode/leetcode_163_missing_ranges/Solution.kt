package leetcode.leetcode_163_missing_ranges

/**
 * leetcode - https://leetcode.com/problems/missing-ranges/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [List]
 * Algorithm -
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
    val result = mutableListOf<List<Int>>()
    if (lower < nums.first()) {
        result.add(listOf(lower, nums.first() - 1))
    }
    for (i in 0..<nums.lastIndex) {
        if (nums[i + 1] - nums[i] > 1) {
            result.add(listOf(nums[i] + 1, nums[i + 1] - 1))
        }
    }
    if (upper > nums.last()) {
        result.add(listOf(nums.last() + 1, upper))
    }
    return result
}

private fun main() {

}
