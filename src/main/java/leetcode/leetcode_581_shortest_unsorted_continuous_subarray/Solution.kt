package leetcode.leetcode_581_shortest_unsorted_continuous_subarray

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/?envType=problem-list-v2&envId=monotonic-stack
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Pointers
 * Algorithm - Two Pass
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun findUnsortedSubarray(nums: IntArray): Int {
    var start = -1
    var end = -2 // ensures 0 result if already sorted
    var maxSeen = nums[0]
    var minSeen = nums[nums.lastIndex]
    for (i in nums.indices) {
        maxSeen = max(maxSeen, nums[i])
        if (nums[i] < maxSeen) end = i
    }
    for (i in nums.lastIndex downTo 0) {
        minSeen = min(minSeen, nums[i])
        if (nums[i] > minSeen) start = i
    }
    return end - start + 1
}

/**
 * leetcode - https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/?envType=problem-list-v2&envId=monotonic-stack
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [ArrayDeque] (Monotonic Increasing Stack)
 * Algorithm - Monotonic Stack
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun findUnsortedSubarrayUsingMonotonicStack(nums: IntArray): Int {
    val stack = ArrayDeque<Pair<Int, Int>>()
    var start = nums.size + 1
    var end = nums.size
    var largestSoFar = nums[0]
    for (i in nums.indices) {
        if (stack.isEmpty() || nums[i] >= largestSoFar) {
            largestSoFar = nums[i]
        } else {
            while (stack.isNotEmpty() && nums[i] < stack.last().first) {
                start = min(start, stack.removeLast().second)
            }
            end = i
        }
        stack.addLast(Pair(nums[i], i))
    }
    return end - start + 1
}

private fun main() {

}
