package leetcode.leet_500_to_599.leet_504_base_7

import kotlin.math.abs

/**
 * Using loops
 *
 * Stats
 * Runtime: 237 ms, faster than 60.00%
 * Memory Usage: 35 MB, less than 40.00%
 */
private fun convertToBase7Naive(num: Int): String {
    if (num == 0) {
        return "0"
    }
    var temp = if (num > 0) {
        num
    } else {
        num * -1
    }
    var result = ""
    while (temp != 0) {
        result = "${temp % 7}$result"
        temp /= 7
    }
    if (num < 0) {
        result = "-$result"
    }
    return result
}

/**
 * Using String builder
 *
 * Stats
 * Runtime: 235 ms, faster than 66.67%
 * Memory Usage: 34.1 MB, less than 86.67%
 */
private fun convertToBase7(num: Int): String {
    if (num == 0) {
        return "0"
    }
    var temp = if (num > 0) {
        num
    } else {
        num * -1
    }
    var result = StringBuilder()
    while (temp != 0) {
        result = result.insert(0, temp % 7)
        temp /= 7
    }
    if (num < 0) {
        result = result.insert(0, "-")
    }
    return result.toString()
}

/**
 * Using String builder and abs
 *
 * Stats
 * Runtime: 235 ms, faster than 66.67%
 * Memory Usage: 34.1 MB, less than 86.67%
 */
private fun convertToBase7UsingAbs(num: Int): String {
    if (num == 0) {
        return "0"
    }
    var temp = abs(num)
    var result = StringBuilder()
    while (temp != 0) {
        result = result.insert(0, temp % 7)
        temp /= 7
    }
    if (num < 0) {
        result = result.insert(0, "-")
    }
    return result.toString()
}

private fun main() {

}
