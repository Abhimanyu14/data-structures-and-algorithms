package leetcode.leetcode_814_binary_tree_pruning

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-pruning/
 *
 * Data Structure - [Tree]
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    if (root.left == null && root.right == null) {
        return if (root.`val` != 1) {
            null
        } else {
            root
        }
    }
    root.left = pruneTree(root.left)
    root.right = pruneTree(root.right)
    return if (root.`val` == 1 || root.left != null || root.right != null) {
        root
    } else {
        null
    }
}

private fun main() {

}
