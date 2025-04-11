package leetcode.leetcode_69_sqrtx

/**
 * leetcode - https://leetcode.com/problems/sqrtx/
 *
 * TODO-Abhi: To revisit
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Stats
 * Runtime: 126 ms, faster than 97.02%
 * Memory Usage: 33.9 MB, less than 16.60%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun mySqrt(x: Int): Int {
    if (x < 2) {
        return x
    }
    var left = 0
    var right = (x / 2) + 1
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (mid.toLong() * mid > x) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left - 1
}

private fun main() {
    mySqrt(101)
}
