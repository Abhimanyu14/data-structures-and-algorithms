package leetcode.leetcode_1004_max_consecutive_ones_iii

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Data Structure - [ArrayDeque] (Queue)
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 4 ms, faster than 89.14%
 * Memory Usage: 40.2 MB, less than 73.02%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun longestOnes(nums: IntArray, k: Int): Int {
    var remainingK = k
    var left = 0
    var right = 0
    while (right < nums.size) {
        if (nums[right] == 0) {
            remainingK--
        }
        // A negative k denotes we have consumed all allowed flips and window has
        // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
        if (remainingK < 0) {
            // If the left element to be thrown out is zero we increase k.
            remainingK += 1 - nums[left]
            left++
        }
        right++
    }
    return right - left
}

/**
 * leetcode - https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Data Structure - [ArrayDeque] (Queue)
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 4 ms, faster than 89.14%
 * Memory Usage: 40.2 MB, less than 73.02%
 *
 * Time - O(N)
 * Space - O(k)
 */
private fun longestOnesUsingQueue(nums: IntArray, k: Int): Int {
    var result = 0
    val queue = ArrayDeque<Int>()
    var current = 0
    for (i in nums.indices) {
        if (nums[i] == 1) {
            current++
            result = max(result, current)
        } else {
            queue.addLast(i)
            if (queue.size > k) {
                current = i - queue.removeFirst()
            } else {
                current++
                result = max(result, current)
            }
        }
    }
    return result
}

private fun longestOnesUsingPointers(nums: IntArray, k: Int): Int {
    var result = 0
    var zeroCount = 0
    var right = 0
    while (right <= nums.lastIndex && (nums[right] == 1 || zeroCount < k)) {
        if (nums[right] == 0) {
            zeroCount++
        }
        result++
        right++
    }
    if (right == nums.size) {
        return result
    }
    var current = result
    var left = 0
    while (right <= nums.lastIndex) {
        while (left <= right && nums[left] == 1) {
            current--
            left++
        }
        left++
        right++
        while (right <= nums.lastIndex && nums[right] == 1) {
            current++
            right++
        }
        result = max(result, current)
    }
    return result
}

private fun main() {

}
