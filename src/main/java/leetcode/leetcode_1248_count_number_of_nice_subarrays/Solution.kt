package leetcode.leetcode_1248_count_number_of_nice_subarrays

/**
 * leetcode - https://leetcode.com/problems/count-number-of-nice-subarrays/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 30 ms, faster than 34.48%
 * Memory Usage: 52.9 MB, less than 5.00%
 *
 * Time - O(4 * N)
 * Space - O(1)
 */
private fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    fun numberOfSubarraysWithLessThanOrEqualTo(goal: Int): Int {
        var result = 0
        var left = 0
        var right = 0
        var currentCount = 0
        while (right <= nums.lastIndex) {
            if (nums[right] % 2 == 1) {
                currentCount++
            }
            while (currentCount > goal) {
                if (nums[left] % 2 == 1) {
                    currentCount--
                }
                left++
            }
            result += (right - left + 1)
            right++
        }
        return result
    }
    return numberOfSubarraysWithLessThanOrEqualTo(k) - numberOfSubarraysWithLessThanOrEqualTo(k - 1)
}

private fun main() {

}
