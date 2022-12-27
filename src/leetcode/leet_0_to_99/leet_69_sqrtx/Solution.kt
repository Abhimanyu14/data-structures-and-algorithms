package leetcode.leet_0_to_99.leet_69_sqrtx

/**
 * leetcode - https://leetcode.com/problems/sqrtx/
 *
 * TODO-Abhi: Revise
 * Using binary search
 *
 * Stats
 * Runtime: 300 ms, faster than 21.89%
 * Memory Usage: 34.3 MB, less than 25.25%
 */
private fun mySqrt(x: Int): Int {
    if (x < 2) {
        return x
    }
    var num: Long
    var pivot: Int
    var left = 2
    var right = x / 2
    while (left <= right) {
        pivot = left + (right - left) / 2
        num = pivot.toLong() * pivot
        if (num > x) {
            right = pivot - 1
        } else if (num < x) {
            left = pivot + 1
        } else {
            return pivot
        }
    }
    return right
}

private fun main() {
    mySqrt(101)
}
