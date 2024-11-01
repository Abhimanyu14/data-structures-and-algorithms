package leetcode.leetcode_2134_minimum_swaps_to_group_all_1_s_together_ii

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minSwaps(nums: IntArray): Int {
    // Initialize minimum swaps to a large value
    var minimumSwaps = Int.MAX_VALUE

    // Calculate the total number of 1s in the array
    var totalOnes = 0
    for (num in nums) {
        totalOnes += num
    }

    // Initialize the count of 1s in the current window
    var onesCount = nums[0]
    var end = 0

    // Slide the window across the array
    for (start in nums.indices) {
        // Adjust onesCount by removing the element that is sliding out of
        // the window
        if (start != 0) {
            onesCount -= nums[start - 1]
        }

        // Expand the window to the right until it reaches the desired size
        while (end - start + 1 < totalOnes) {
            end++
            onesCount += nums[end % nums.size]
        }

        // Update the minimum number of swaps needed
        minimumSwaps = min(minimumSwaps.toDouble(), (totalOnes - onesCount).toDouble()).toInt()
    }

    return minimumSwaps
}

private fun main() {

}
