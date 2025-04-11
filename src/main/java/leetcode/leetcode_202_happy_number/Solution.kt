package leetcode.leetcode_202_happy_number

import data_structures_and_algorithms.number.toDigits

/**
 * leetcode - https://leetcode.com/problems/happy-number/
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 152 ms, faster than 50.60%
 * Memory Usage: 35.2 MB, less than 16.87%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun isHappy(n: Int): Boolean {
    var ele = n
    while (ele >= 10) {
        ele = toDigits(ele).sumOf { it * it }
    }
    return ele == 1 || ele == 7
}

private fun main() {
    val input1 = 19
    val input2 = 2
    val input3 = 10
    println(isHappy(input1))
    println(isHappy(input2))
    println(isHappy(input3))
}
