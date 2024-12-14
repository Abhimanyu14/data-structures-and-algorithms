package leetcode.leetcode_2762_continuous_subarrays

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/continuous-subarrays/?envType=daily-question&envId=2024-12-14
 *
 * Data Structure - Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 685 ms, faster than 100.00%
 * Memory Usage: 78.2 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private class Solution {
    fun continuousSubarrays(nums: IntArray): Long {
        var result: Long = 0
        var right = 0
        var left = 0
        var curMin = nums[right]
        var curMax = nums[right]
        var windowLen: Long
        while (right < nums.size) {
            curMin = min(curMin, nums[right])
            curMax = max(curMax, nums[right])
            if (curMax - curMin > 2) {
                // Add subarrays from previous valid window
                windowLen = (right - left).toLong()
                result += ((windowLen * (windowLen + 1)) / 2)

                // Start new window at current position
                left = right
                curMax = nums[right]
                curMin = curMax

                // Expand left boundary while maintaining condition
                while (left > 0 && abs((nums[right] - nums[left - 1])) <= 2) {
                    left--
                    curMin = min(curMin, nums[left])
                    curMax = max(curMax, nums[left])
                }

                // Remove over counted subarrays if left boundary expanded
                if (left < right) {
                    windowLen = (right - left).toLong()
                    result -= ((windowLen * (windowLen + 1)) / 2)
                }
            }
            right++
        }

        // Add subarrays from final window
        windowLen = (right - left).toLong()
        result += ((windowLen * (windowLen + 1)) / 2)

        return result
    }
}

/**
 * leetcode - https://leetcode.com/problems/continuous-subarrays/?envType=daily-question&envId=2024-12-14
 *
 * Data Structure - Pointers
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 685 ms, faster than 100.00%
 * Memory Usage: 77.1 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun continuousSubarraysUsingSlidingWindow(nums: IntArray): Long {
    var result = 0L
    val counter = mutableMapOf<Int, Int>()
    var left = 0
    var right = 0
    var minValue: Int = Int.MAX_VALUE
    var maxValue: Int = Int.MIN_VALUE
    while (right <= nums.lastIndex) {
        counter[nums[right]] = counter.getOrDefault(nums[right], 0) + 1
        minValue = min(minValue, nums[right])
        maxValue = max(maxValue, nums[right])
        while (maxValue - minValue > 2) {
            if (counter.getOrDefault(nums[left], 0) == 1) {
                counter.remove(nums[left])
            } else {
                counter[nums[left]] = counter.getOrDefault(nums[left], 0) - 1
            }
            if (minValue == nums[left]) {
                minValue = counter.keys.min()
            } else if (maxValue == nums[left]) {
                maxValue = counter.keys.max()
            }
            left++
        }
        result += (right - left + 1)
        right++
    }
    return result
}


/**
 * leetcode - https://leetcode.com/problems/continuous-subarrays/?envType=daily-question&envId=2024-12-14
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun continuousSubarraysUsingBruteForce(nums: IntArray): Long {
    var result = 0L
    var minValue: Int
    var maxValue: Int
    for (i in nums.indices) {
        minValue = nums[i]
        maxValue = nums[i]
        result++
        for (j in (i + 1)..nums.lastIndex) {
            minValue = min(minValue, nums[j])
            maxValue = max(maxValue, nums[j])
            if (maxValue - minValue <= 2) {
                result++
            } else {
                break
            }
        }
    }
    return result
}

private fun main() {

}
