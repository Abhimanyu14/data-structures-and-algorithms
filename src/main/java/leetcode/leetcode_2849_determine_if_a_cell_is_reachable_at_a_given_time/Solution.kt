package leetcode.leetcode_2849_determine_if_a_cell_is_reachable_at_a_given_time

import kotlin.math.abs
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
 *
 * Using conditions
 *
 * Stats
 * Runtime: 149 ms, faster than 25.00%
 * Memory Usage: 33.8 MB, less than 73.08%
 */
private fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
    max(abs(sx - fx), abs(sy - fy)).let {
        return if (it == 0) {
            t != 1
        } else {
            it <= t
        }
    }
}

private fun main() {

}
