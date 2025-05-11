package leetcode.leetcode_202_happy_number

import data_structures.number.toDigits

/**
 * leetcode - https://leetcode.com/problems/happy-number/
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta, Microsoft
 */
private fun isHappyUsingRecursion(n: Int): Boolean {
    if (n < 9) {
        return n == 1 || n == 7
    }
    var sum = 0
    var current = n
    while (current != 0) {
        sum += ((current % 10) * (current % 10))
        current /= 10
    }
    return isHappyUsingRecursion(sum)
}

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
