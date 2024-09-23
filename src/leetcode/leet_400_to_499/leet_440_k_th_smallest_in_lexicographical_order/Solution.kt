package leetcode.leet_400_to_499.leet_440_k_th_smallest_in_lexicographical_order

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?envType=daily-question&envId=2024-09-22
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class Solution {
    fun findKthNumber(n: Int, k: Int): Int {
        var k = k
        var curr = 1
        k--

        while (k > 0) {
            val step = countSteps(n, curr.toLong(), (curr + 1).toLong())
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (step <= k) {
                // Move to the next prefix and decrease k by the number of steps we skip
                curr++
                k -= step
            } else {
                // Move to the next level of the tree and decrement k by 1
                curr *= 10
                k--
            }
        }

        return curr
    }

    // To count how many numbers exist between prefix1 and prefix2
    private fun countSteps(n: Int, prefix1: Long, prefix2: Long): Int {
        var prefix1 = prefix1
        var prefix2 = prefix2
        var steps = 0
        while (prefix1 <= n) {
            steps += (min((n + 1).toDouble(), prefix2.toDouble()) - prefix1).toInt()
            prefix1 *= 10
            prefix2 *= 10
        }
        return steps
    }
}

private fun main() {

}
