package leetcode.leetcode_995_minimum_number_of_k_consecutive_bit_flips

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minKBitFlips(nums: IntArray, k: Int): Int {
    var currentFlips = 0 // Tracks the current number of flips
    var totalFlips = 0 // Tracks the total number of flips

    for (i in nums.indices) {
        // If the window slides out of the range and the leftmost element is
        // marked as flipped (2), decrement currentFlips
        if (i >= k && nums[i - k] == 2) {
            currentFlips--
        }

        // Check if the current bit needs to be flipped
        if ((currentFlips % 2) == nums[i]) {
            // If flipping would exceed array bounds, return -1
            if (i + k > nums.size) {
                return -1
            }
            // Mark the current bit as flipped
            nums[i] = 2
            currentFlips++
            totalFlips++
        }
    }

    return totalFlips
}

private fun main() {

}
