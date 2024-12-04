package leetcode.leetcode_930_binary_subarrays_with_sum

/**
 * leetcode - https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * Data Structure -  Two Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 19 ms, faster than 41.46%
 * Memory Usage: 42.8 MB, less than 22.58%
 *
 * Time -
 * Space -
 */
private fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    fun numSubarraysWithSumLessThanOrEqualTo(goal: Int): Int {
        if (goal < 0) {
            return 0
        }
        var result = 0
        var left = 0
        var right = 0
        var currentSum = 0
        while (right <= nums.lastIndex) {
            currentSum += nums[right]
            while (currentSum > goal) {
                currentSum -= nums[left]
                left++
            }
            result += (right - left + 1)
            right++
        }
        return result
    }
    return numSubarraysWithSumLessThanOrEqualTo(goal) - numSubarraysWithSumLessThanOrEqualTo(goal - 1)
}

/**
 * leetcode - https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * Data Structure - Map
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 29 ms, faster than 41.46%
 * Memory Usage: 45.1 MB, less than 6.45%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun numSubarraysWithSumWithMap(nums: IntArray, goal: Int): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = 1
    var currentSum = 0
    nums.forEach {
        currentSum += it
        result += map.getOrDefault(currentSum - goal, 0)
        map[currentSum] = map.getOrDefault(currentSum, 0) + 1
    }
    return result
}

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
private fun numSubarraysWithSumUsingBruteForce(nums: IntArray, goal: Int): Int {
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
