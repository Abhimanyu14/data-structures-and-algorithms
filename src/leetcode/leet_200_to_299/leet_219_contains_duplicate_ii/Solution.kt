package leetcode.leet_200_to_299.leet_219_contains_duplicate_ii

/**
 * leetcode - https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Using set
 *
 * Stats
 * Runtime: 540 ms, faster than 96.75%
 * Memory Usage: 58.1 MB, less than 82.79%
 */
private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
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
