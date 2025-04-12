package leetcode.leetcode_938_range_sum_of_bst

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/range-sum-of-bst/
 *
 * Data Structure - Tree
 * Algorithm - DFS Optimized
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 689 ms, faster than 36.84%
 * Memory Usage: 72.2 MB, less than 34.21%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    return if (root == null) {
        0
    } else if (root.`val` < low) {
        rangeSumBST(root.right, low, high)
    } else if (root.`val` > high) {
        rangeSumBST(root.left, low, high)
    } else {
        root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
}

private fun main() {

}
