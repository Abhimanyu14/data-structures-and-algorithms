package leetcode.leetcode_219_contains_duplicate_ii

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Data Structure - [Set]
 * Algorithm - Hashing and Sliding Window
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 540 ms, faster than 96.75%
 * Memory Usage: 58.1 MB, less than 82.79%
 *
 * Time - O(N)
 * Space - O(k)
 *
 * Companies - Meta
 */
private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val window = mutableSetOf<Int>()
    for (i in 0..min(k, nums.lastIndex)) {
        if (!window.add(nums[i])) {
            return true
        }
    }
    for (i in (k + 1)..nums.lastIndex) {
        window.remove(nums[i - k - 1])
        if (!window.add(nums[i])) {
            return true
        }
    }
    return false
}

private fun containsNearbyDuplicateUsingSingleLoop(nums: IntArray, k: Int): Boolean {
    val set = mutableSetOf<Int>()
    for (i in nums.indices) {
        if (i > k) {
            set.remove(nums[i - k - 1])
        }
        if (set.contains(nums[i])) {
            return true
        }
        set.add(nums[i])
    }
    return false
}

private fun main() {

}
