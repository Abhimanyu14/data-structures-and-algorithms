package leetcode.leetcode_977_squares_of_a_sorted_array

import kotlin.math.abs
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search & Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var left = 0
    var right = nums.size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] >= 0) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    var current = left
    var prev = current - 1
    var index = 0
    while (current <= nums.lastIndex && prev >= 0) {
        if (abs(nums[current]) < abs(nums[prev])) {
            result[index] = nums[current] * nums[current]
            current++
        } else {
            result[index] = nums[prev] * nums[prev]
            prev--
        }
        index++
    }
    while (current <= nums.lastIndex) {
        result[index] = nums[current] * nums[current]
        current++
        index++
    }
    while (prev >= 0) {
        result[index] = nums[prev] * nums[prev]
        prev--
        index++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Using two pointer
 *
 * Stats
 * Runtime: 736 ms, faster than 31.25%
 * Memory Usage: 71.6 MB, less than 49.78%
 */
private fun sortedSquaresUsingTwoPointer(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var positive = 0
    var insertionPointer = 0
    while (positive < nums.size && nums[positive] <= 0) {
        positive++
    }
    var nonPositive = positive - 1

    while (insertionPointer < nums.size) {
        if (positive < nums.size && nonPositive >= 0) {
            if (abs(nums[positive]) < abs(nums[nonPositive])) {
                result[insertionPointer] = nums[positive].toDouble().pow(2.0).toInt()
                positive++
            } else {
                result[insertionPointer] = nums[nonPositive].toDouble().pow(2.0).toInt()
                nonPositive--
            }
        } else {
            if (positive < nums.size) {
                result[insertionPointer] = nums[positive].toDouble().pow(2.0).toInt()
                positive++
            } else {
                result[insertionPointer] = nums[nonPositive].toDouble().pow(2.0).toInt()
                nonPositive--
            }
        }

        insertionPointer++
    }
    return result
}

private fun main() {
    println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).joinToString(", "))
    println(sortedSquares(intArrayOf(0, 1, 3, 4, 10)).joinToString(", "))
    println(sortedSquares(intArrayOf(0)).joinToString(", "))
}
