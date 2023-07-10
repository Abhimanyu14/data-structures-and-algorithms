package leetcode.leet_100_to_199.leet_110_balanced_binary_tree

import data_structures.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * Using recursion
 *
 * Stats
 * Runtime: 445 ms, faster than 5.10%
 * Memory Usage: 44.8 MB, less than 8.84%
 */
private fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    return isBalancedHelper(root) != -1
}

private fun isBalancedHelper(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val leftDepth = isBalancedHelper(root.left)
    val rightDepth = isBalancedHelper(root.right)
    if (leftDepth == -1 || rightDepth == -1 || abs(leftDepth - rightDepth) > 1) {
        return -1
    }
    return 1 + max(leftDepth, rightDepth)
}

private fun main() {

}
