package leetcode.leetcode_900_to_999.leetcode_977_squares_of_a_sorted_array

import kotlin.math.abs
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 282 ms, faster than 63.46%
 * Memory Usage: 42.5 MB, less than 30.98%
 */
private fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var low = 0
    var high = nums.lastIndex
    var mid: Int
    while (low < high) {
        mid = low + ((high - low) / 2)
        if (nums[mid] >= 0) {
            high = mid
        } else {
            low = mid + 1
        }
    }

    high = low
    low--

    repeat(nums.size) {
        if (low == -1) {
            result[it] = nums[high] * nums[high]
            high++
        } else if (high == nums.size) {
            result[it] = nums[low] * nums[low]
            low--
        } else if (nums[low] * nums[low] <= nums[high] * nums[high]) {
            result[it] = nums[low] * nums[low]
            low--
        } else {
            result[it] = nums[high] * nums[high]
            high++
        }
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
