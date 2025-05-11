package leetcode.leetcode_112_path_sum

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/path-sum/
 *
 * Data Structure - Tree
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }
    fun getPathSum(current: TreeNode, sumSoFar: Int): Boolean {
        if (current.left == null && current.right == null) {
            return sumSoFar + current.`val` == targetSum
        }
        val left = current.left?.let {
            getPathSum(it, sumSoFar + current.`val`)
        } ?: false
        val right = current.right?.let {
            getPathSum(it, sumSoFar + current.`val`)
        } ?: false
        return left || right
    }
    return getPathSum(root, 0)
}

private fun main() {

}
