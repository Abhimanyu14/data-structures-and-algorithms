package leetcode.leetcode_3340_check_balanced_string

/**
 * leetcode - https://leetcode.com/problems/check-balanced-string/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 35.5 MB, less than 54.37%
 *
 * Time -
 * Space -
 */
private fun isBalanced(num: String): Boolean {
    var evenSum = 0
    var oddSum = 0
    for (i in num.indices) {
        if (i % 2 == 0) {
            evenSum += num[i] - '0'
        } else {
            oddSum += num[i] - '0'
        }
    }
    return evenSum == oddSum
}

private fun main() {

}
