package leetcode.leetcode_1283_find_the_smallest_divisor_given_a_threshold

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 40 ms, faster than 30.00%
 * Memory Usage: 42.6 MB, less than 15.38%
 *
 * Time -
 * Space -
 */
private fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    fun check(x: Int): Boolean {
        var count = 0
        for (num in nums) {
            count += ceil(num.toDouble() / x).toInt()
        }
        return count <= threshold
    }
    var left = 1
    var right = nums.max()
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (check(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
