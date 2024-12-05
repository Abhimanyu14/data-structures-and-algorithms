package leetcode.leetcode_1134_armstrong_number

import kotlin.math.log10
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/armstrong-number/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction, Power and Log 10
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.38 MB, less than 25.00507%
 *
 * Time -
 * Space -
 */
private fun isArmstrong(n: Int): Boolean {
    val power = log10(n.toDouble()).toInt() + 1
    var sum = 0
    var temp = n
    while (temp != 0) {
        sum += (temp % 10).toDouble().pow(power).toInt()
        temp /= 10
    }
    return sum == n
}

private fun main() {

}
