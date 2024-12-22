package leetcode.leetcode_1323_maximum_69_number

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/maximum-69-number/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction and Maths
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.8 MB, less than 47.62%
 *
 * Time -
 * Space -
 */
private fun maximum69Number (num: Int): Int {
    var firstSix = -1
    var temp = num
    var current = 0
    while (temp != 0) {
        if (temp % 10 == 6) {
            firstSix = current
        }
        temp /= 10
        current++
    }
    return if (firstSix == -1) {
        num
    } else {
        num + (3 * (10.0).pow(firstSix)).toInt()
    }
}

private fun main() {

}
