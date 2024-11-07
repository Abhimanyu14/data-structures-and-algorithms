package leetcode.leetcode_1758_minimum_changes_to_make_alternating_binary_string

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/submissions/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 185 ms, faster than 11.11%
 * Memory Usage: 36.2 MB, less than 100.00%
 */
private fun minOperations(s: String): Int {
    var evenZero = 0
    var oddZero = 0
    s.forEachIndexed { index, char ->
        if (char == '1') {
            if (index % 2 == 0) {
                evenZero++
            } else {
                oddZero++
            }
        } else {
            if (index % 2 == 0) {
                oddZero++
            } else {
                evenZero++
            }
        }
    }
    return min(evenZero, oddZero)
}

private fun main() {

}
