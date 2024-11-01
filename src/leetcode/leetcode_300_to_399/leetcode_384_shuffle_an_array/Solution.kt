package leetcode.leetcode_300_to_399.leetcode_384_shuffle_an_array

import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/shuffle-an-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private class Solution(var nums: IntArray) {
    private val original: IntArray = nums.clone()

    fun reset(): IntArray {
        nums = original.clone()
        return nums
    }

    fun shuffle(): IntArray {
        val temp = original.clone().toMutableList()
        var randomIndex: Int
        repeat(original.size) {
            randomIndex = Random.nextInt(1, temp.size)
            nums[it] = temp[randomIndex]
            temp.removeAt(randomIndex)
        }
        return nums
    }
}

private fun main() {
    val obj = Solution(intArrayOf(1, 2, 3))
    obj.reset()
    println(obj.nums.joinToString(", "))
    obj.shuffle()
    println(obj.nums.joinToString(", "))
}
