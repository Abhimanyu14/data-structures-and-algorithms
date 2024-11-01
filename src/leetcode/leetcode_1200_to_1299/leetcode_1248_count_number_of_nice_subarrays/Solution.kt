package leetcode.leetcode_1200_to_1299.leetcode_1248_count_number_of_nice_subarrays

/**
 * leetcode - https://leetcode.com/problems/count-number-of-nice-subarrays/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    fun atMost(k: Int): Int {
        var windowSize = 0
        var subarrays = 0
        var start = 0

        for (end in nums.indices) {
            windowSize += nums[end] % 2
            // Find the first index start where the window has exactly k odd elements.
            while (windowSize > k) {
                windowSize -= nums[start] % 2
                start++
            }
            // Increment number of subarrays with end - start + 1.
            subarrays += end - start + 1
        }
        return subarrays
    }

    return atMost(k) - atMost(k - 1)
}

private fun main() {

}
