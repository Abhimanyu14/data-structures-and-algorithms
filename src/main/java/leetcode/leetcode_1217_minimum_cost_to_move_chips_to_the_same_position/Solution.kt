package leetcode.leetcode_1217_minimum_cost_to_move_chips_to_the_same_position

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun minCostToMoveChips(position: IntArray): Int {
    var oddCount = 0
    var evenCount = 0
    for (num in position) {
        if (num % 2 == 0) {
            evenCount++
        } else {
            oddCount++
        }
    }
    return min(oddCount, evenCount)
}

private fun main() {

}
