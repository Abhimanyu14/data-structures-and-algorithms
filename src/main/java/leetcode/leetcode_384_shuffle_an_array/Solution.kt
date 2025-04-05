package leetcode.leetcode_384_shuffle_an_array

import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/shuffle-an-array/
 *
 * Data Structure - [Random]
 * Algorithm - Randomization
 *
 * Array methods - [Array.clone]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class Solution(val nums: IntArray) {
    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val result = nums.clone()
        for (i in nums.indices) {
            val swapIndex = Random.nextInt(nums.size)
            result[i] = result[swapIndex].also {
                result[swapIndex] = result[i]
            }
        }
        return result
    }
}

private fun main() {
    val obj = Solution(intArrayOf(1, 2, 3))
    obj.reset()
    println(obj.nums.joinToString(", "))
    obj.shuffle()
    println(obj.nums.joinToString(", "))
}
