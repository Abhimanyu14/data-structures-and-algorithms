package leetcode.leetcode_3687_library_late_fee_calculator

/**
 * leetcode - https://leetcode.com/problems/library-late-fee-calculator/
 *
 *
 * Data Structure - Array
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies -
 */
private fun lateFee(daysLate: IntArray): Int {
    var result = 0
    for (days in daysLate) {
        result += if (days == 1) {
            1
        } else if (days <= 5) {
            days * 2
        } else {
            days * 3
        }
    }
    return result
}

private fun main() {

}
