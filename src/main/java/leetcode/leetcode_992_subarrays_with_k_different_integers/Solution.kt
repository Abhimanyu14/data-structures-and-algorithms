package leetcode.leetcode_992_subarrays_with_k_different_integers

/**
 * leetcode - https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 84 ms, faster than 43.75%
 * Memory Usage: 43.1 MB, less than 15.79%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    fun subarraysWithAtMostDistinct(goal: Int): Int {
        var result = 0
        var left = 0
        var right = 0
        val currentMap = mutableMapOf<Int, Int>()
        while (right <= nums.lastIndex) {
            currentMap[nums[right]] = currentMap.getOrDefault(nums[right], 0) + 1
            while (currentMap.size > goal) {
                if (currentMap.getOrDefault(nums[left], 0) == 1) {
                    currentMap.remove(nums[left])
                } else {
                    currentMap[nums[left]] = currentMap.getOrDefault(nums[left], 0) - 1
                }
                left++
            }
            result += (right - left + 1)
            right++
        }
        return result
    }
    return subarraysWithAtMostDistinct(k) - subarraysWithAtMostDistinct(k - 1)
}

/**
 * leetcode - https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * Using brute force
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^3)
 * Space - O(N)
 */
private fun subarraysWithKDistinctUsingBruteForce(nums: IntArray, k: Int): Int {
    if (nums.size < k) {
        return 0
    }
    var result = 0
    val set = mutableSetOf<Int>()
    for (window in k..nums.size) {
        for (i in 0..(nums.lastIndex - window + 1)) {
            set.clear()
            for (j in i..<i + window) {
                set.add(nums[j])
            }
            if (set.size == k) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
