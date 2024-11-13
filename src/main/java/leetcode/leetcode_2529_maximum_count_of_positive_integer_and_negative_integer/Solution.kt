package leetcode.leetcode_2529_maximum_count_of_positive_integer_and_negative_integer

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/?envType=problem-list-v2&envId=binary-search&difficulty=EASY
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 16 ms, faster than 50.00%
 * Memory Usage: 40.7 MB, less than 9.09%
 *
 * Time - O(log N)
 * Space - O(1)
 */
private fun maximumCount(nums: IntArray): Int {
    var left = 0
    var right = nums.size
    var mid: Int
    while (left < right) {
        mid = (left + (right - left) / 2)
        if (nums[mid] >= 0) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    val lastNegativeNumberIndex = left - 1
    left = lastNegativeNumberIndex + 1
    right = nums.size
    while (left < right) {
        mid = (left + (right - left) / 2)
        if (nums[mid] > 0) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return max((nums.lastIndex - left + 1), lastNegativeNumberIndex + 1)
}

private fun main() {

}
