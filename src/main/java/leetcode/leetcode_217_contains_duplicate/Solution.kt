package leetcode.leetcode_217_contains_duplicate

/**
 * leetcode - https://leetcode.com/problems/contains-duplicate/
 *
 * Data Structure - Set
 * Algorithm - Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 391 ms, faster than 95.97%
 * Memory Usage: 52.4 MB, less than 60.87%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in nums) {
        if (set.contains(num)) {
            return true
        }
        set.add(num)
    }
    return false
}

private fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4)))
}
