package leetcode.leetcode_2064_minimized_maximum_of_products_distributed_to_any_store

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 71 ms, faster than 50.38%
 * Memory Usage: 57.3 MB, less than 66.67%
 *
 * Time -
 * Space -
 */
private fun minimizedMaximum(n: Int, quantities: IntArray): Int {
    fun canDistribute(x: Int): Boolean {
        var count = 0
        for (quantity in quantities) {
            count += ceil(quantity.toDouble() / x).toInt()
        }
        return count <= n
    }

    var left = 1
    var right = quantities.max()
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (canDistribute(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
