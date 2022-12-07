package leetcode.leet_900_to_999.leet_938_range_sum_of_bst

import data_structures.data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/range-sum-of-bst/
 * Using DFS Optimized
 *
 * Stats
 * Runtime: 689 ms, faster than 36.84%
 * Memory Usage: 72.2 MB, less than 34.21%
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

/**
 * Using DFS
 *
 * Stats
 * Runtime: 405 ms, faster than 81.58%
 * Memory Usage: 47.2 MB, less than 78.95%
 */
private fun rangeSumBSTDfs(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) {
        return 0
    }
    val add = if (root.`val` < low || root.`val` > high) {
        0
    } else {
        root.`val`
    }
    return add + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
}

private fun main() {

}
