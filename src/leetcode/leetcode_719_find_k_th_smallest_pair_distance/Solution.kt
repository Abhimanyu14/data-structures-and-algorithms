package leetcode.leetcode_719_find_k_th_smallest_pair_distance

import java.util.Arrays

/**
 * leetcode - https://leetcode.com/problems/find-k-th-smallest-pair-distance/?envType=daily-question&envId=2024-08-14
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
private fun smallestDistancePair(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    val arraySize = nums.size

    // Initialize binary search range
    var low = 0
    var high = nums[arraySize - 1] - nums[0]

    while (low < high) {
        val mid = (low + high) / 2

        // Count pairs with distance <= mid
        val count = countPairsWithMaxDistance(nums, mid)

        // Adjust binary search bounds based on count
        if (count < k) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}

// Count number of pairs with distance <= maxDistance using a moving window
private fun countPairsWithMaxDistance(nums: IntArray, maxDistance: Int): Int {
    var count = 0
    val arraySize = nums.size
    var left = 0

    for (right in 0 until arraySize) {
        // Adjust the left pointer to maintain the window with distances <=
        // maxDistance
        while (nums[right] - nums[left] > maxDistance) {
            ++left
        }
        // Add the number of valid pairs ending at the current right index
        count += right - left
    }
    return count
}

private fun main() {

}
