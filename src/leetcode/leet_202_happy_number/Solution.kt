package leetcode.leet_202_happy_number

import common.number.toDigits

/**
 * Stats
 * Runtime: 152 ms, faster than 50.60%
 * Memory Usage: 35.2 MB, less than 16.87%
 */
fun isHappy(n: Int): Boolean {
    var ele = n
    while (ele >= 10) {
        ele = toDigits(ele).map { it * it }.sum()
    }
    return ele == 1 || ele == 7
}

fun main() {
    val input1 = 19
    val input2 = 2
    val input3= 10
    println(isHappy(input1))
    println(isHappy(input2))
    println(isHappy(input3))
}
