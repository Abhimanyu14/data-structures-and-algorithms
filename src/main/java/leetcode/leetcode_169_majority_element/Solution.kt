package leetcode.leetcode_169_majority_element

/**
 * leetcode - https://leetcode.com/problems/majority-element/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Boyer-Moore Majority Voting Algorithm
 * Source: https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 265 ms, faster than 66.55%
 * Memory Usage: 43.3 MB, less than 51.92%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun majorityElement(nums: IntArray): Int {
    var candidate: Int = nums[0]
    var count = 1
    for (i in 1..nums.lastIndex) {
        if (candidate == nums[i]) {
            count++
        } else {
            count--
            if (count == 0) {
                count = 1
                candidate = nums[i]
            }
        }
    }
    return candidate
}

private fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}
