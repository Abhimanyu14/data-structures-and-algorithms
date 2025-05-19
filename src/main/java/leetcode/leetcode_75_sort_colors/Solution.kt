package leetcode.leetcode_75_sort_colors

/**
 * leetcode - https://leetcode.com/problems/sort-colors/
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * a.k.a. - Dutch National Flag Problem
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 10 ms, faster than 20.25%
 * Memory Usage: 46.15 MB, less than 6.08%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun sortColors(nums: IntArray) {
    var current = 0
    var left = 0
    var right = nums.lastIndex
    fun swap(x: Int, y: Int) {
        nums[x] = nums[y].also {
            nums[y] = nums[x]
        }
    }
    while (current <= right) {
        when (nums[current]) {
            0 -> {
                swap(current, left)
                left++
                current++
            }

            2 -> {
                swap(current, right)
                right--
            }

            else -> {
                current++
            }
        }
    }
}

/**
 * leetcode - https://leetcode.com/problems/sort-colors/
 *
 * Data Structure - Three Pointers
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 177 ms, faster than 20.10%
 * Memory Usage: 34.7 MB, less than 61.32%
 *
 * Time -
 * Space -
 */
private fun sortColorsUsingThreePointers(nums: IntArray) {
    var zeroCount = 0
    var oneCount = 0
    var twoCount = 0
    for (num in nums) {
        when (num) {
            0 -> {
                zeroCount++
            }

            1 -> {
                oneCount++
            }

            else -> {
                twoCount++
            }
        }
    }

    var index = 0
    while (zeroCount > 0) {
        nums[index] = 0
        index++
        zeroCount--
    }
    while (oneCount > 0) {
        nums[index] = 1
        index++
        oneCount--
    }
    while (twoCount > 0) {
        nums[index] = 2
        index++
        twoCount--
    }
}

private fun main() {
    val input1 = intArrayOf(1, 2, 0)
    sortColors(input1)
    println(input1.joinToString(", "))
}
