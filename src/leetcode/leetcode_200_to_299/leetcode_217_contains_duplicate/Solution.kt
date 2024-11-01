package leetcode.leetcode_200_to_299.leetcode_217_contains_duplicate

/**
 * leetcode - https://leetcode.com/problems/contains-duplicate/
 *
 * Using Set
 *
 * Stats
 * Runtime: 391 ms, faster than 95.97%
 * Memory Usage: 52.4 MB, less than 60.87%
 */
private fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (i in nums.indices) {
        if (set.contains(nums[i])) {
            return true
        }
        set.add(nums[i])
    }
    return false
}

private fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4)))
}
