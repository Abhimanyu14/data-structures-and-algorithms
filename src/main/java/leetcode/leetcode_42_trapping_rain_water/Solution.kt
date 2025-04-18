package leetcode.leetcode_42_trapping_rain_water

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/trapping-rain-water/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Sliding Window
 *
 * Stats
 * Runtime: 16 ms, faster than 38.97%
 * Memory Usage: 39.4 MB, less than 93.68%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun trap(height: IntArray): Int {
    var result = 0
    var leftMax = 0
    var rightMax = 0
    var left = 0
    var right = height.lastIndex
    while (left < right) {
        if (height[left] <= height[right]) {
            leftMax = max(leftMax, height[left])
            result += leftMax - height[left]
            left++
        } else {
            rightMax = max(rightMax, height[right])
            result += rightMax - height[right]
            right--
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/trapping-rain-water/
 *
 * Using dynamic programming
 *
 * Stats
 * Runtime: 268 ms, faster than 68.31%
 * Memory Usage: 38.8 MB, less than 79.78%
 */
private fun trapUsingDp(height: IntArray): Int {
    val leftMax = IntArray(height.size)
    val rightMax = IntArray(height.size)
    var left = 0
    var right = 0
    for (i in height.indices) {
        left = max(left, height[i])
        leftMax[i] = left
        right = max(right, height[height.lastIndex - i])
        rightMax[height.lastIndex - i] = right
    }
    var result = 0
    for (i in height.indices) {
        result += min(leftMax[i], rightMax[i]) - height[i]
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/trapping-rain-water/
 *
 * Using dynamic programming
 *
 * Stats
 * Runtime: 268 ms, faster than 68.31%
 * Memory Usage: 38.8 MB, less than 79.78%
 */
private fun trapUsingStack(height: IntArray): Int {
    var ans = 0
    var current = 0
    val stack = ArrayDeque<Int>()
    while (current < height.size) {
        while (!stack.isEmpty() && height[current] > height[stack.last()]) {
            val top = stack.last()
            stack.removeLast()
            if (stack.isEmpty()) {
                break
            }
            val distance = current - stack.last() - 1
            val boundedHeight = min(height[current], height[stack.last()]) - height[top]
            ans += distance * boundedHeight
        }
        stack.addLast(current++)
    }
    return ans
}

private fun main() {
}
