package leetcode.leetcode_101_symmetric_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/symmetric-tree/
 *
 * Data Structure - [Tree]
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 166 ms, faster than 23.66%
 * Memory Usage: 34.4 MB, less than 85.07%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    fun check(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }
        if (left?.`val` != right?.`val`) {
            return false
        }
        return check(left?.left, right?.right) && check(left?.right, right?.left)
    }
    return check(root.left, root.right)
}

/**
 * leetcode - https://leetcode.com/problems/symmetric-tree/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 208 ms, faster than 5.35%
 * Memory Usage: 38.8 MB, less than 5.07%
 */
private fun isSymmetricUsingIteration(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    if (root.left == null && root.right == null) {
        return true
    }
    if (root.left == null || root.right == null) {
        return false
    }
    val stack = ArrayDeque<TreeNode>()
    stack.addLast(root.left!!)
    stack.addLast(root.right!!)
    while (stack.isNotEmpty()) {
        val right = stack.removeLast()
        val left = stack.removeLast()
        if (left.`val` != right.`val`) {
            return false
        }
        if (left.left != null && right.right != null) {
            stack.addLast(left.left!!)
            stack.addLast(right.right!!)
        } else if (left.left != null || right.right != null) {
            return false
        }
        if (left.right != null && right.left != null) {
            stack.addLast(left.right!!)
            stack.addLast(right.left!!)
        } else if (left.right != null || right.left != null) {
            return false
        }
    }
    return true
}

private fun main() {

}
