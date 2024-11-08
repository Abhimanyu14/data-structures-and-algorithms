package leetcode.leetcode_1829_maximum_xor_for_each_query

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/maximum-xor-for-each-query/?envType=daily-question&envId=2024-11-08
 *
 * Using bitwise operation - XOR
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 21 ms, faster than 100.00%
 * Memory Usage: 52.9 MB, less than 87.50%
 *
 * Time -
 * Space -
 */
private fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
    val result = IntArray(nums.size)
    val maxValue = (2.0).pow(maximumBit).toInt() - 1
    var current = 0
    nums.forEach {
        current = current xor it
    }
    for (i in nums.indices) {
        result[i] = current xor maxValue
        current = current xor nums[nums.lastIndex - i]
    }
    return result
}

private fun main() {

}
