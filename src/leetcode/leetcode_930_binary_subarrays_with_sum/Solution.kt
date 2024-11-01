package leetcode.leetcode_930_binary_subarrays_with_sum

/**
 * leetcode - https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 * Runtime: 220 ms, faster than 93.33%
 * Memory Usage: 40.5 MB, less than 96.67%
 */
private fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    var start = 0
    var prefixZeros = 0
    var currentSum = 0
    var totalCount = 0
    // Loop through the array using end pointer
    for (end in nums.indices) {
        // Add current element to the sum
        currentSum += nums[end]
        // Slide the window while condition is met
        while (start < end && (nums[start] == 0 || currentSum > goal)) {
            if (nums[start] == 1) {
                prefixZeros = 0
            } else {
                prefixZeros++
            }
            currentSum -= nums[start]
            start++
        }
        // Count subarrays when window sum matches the goal
        if (currentSum == goal) {
            totalCount += 1 + prefixZeros
        }
    }
    return totalCount
}

private fun main() {

}
