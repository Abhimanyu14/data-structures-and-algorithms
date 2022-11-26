package leetcode.leet_100_to_199.leet_169_majority_element

/**
 * Using Boyer-Moore Majority Voting Algorithm
 * Source: https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
 *
 * Stats
 * Runtime: 358 ms, faster than 82.50%
 * Memory Usage: 52 MB, less than 66.88%
 */
private fun majorityElement(nums: IntArray): Int {
    var majority = nums[0]
    var count = 1
    for (i in 1..nums.lastIndex) {
        if (nums[i] == majority) {
            count++
        } else {
            count--
            if (count == 0) {
                majority = nums[i]
                count = 1
            }
        }
    }
    return majority
}

fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}
