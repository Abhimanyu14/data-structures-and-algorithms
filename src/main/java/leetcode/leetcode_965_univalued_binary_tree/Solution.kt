package leetcode.leetcode_965_univalued_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/univalued-binary-tree/description/
 *
 * Data Structure - [Tree]
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun isUnivalTree(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    fun isSame(current: TreeNode, rootValue: Int): Boolean {
        if (current.`val` != rootValue) {
            return false
        }
        val left = current.left?.let {
            isSame(it, rootValue)
        } ?: true
        val right = current.right?.let {
            isSame(it, rootValue)
        } ?: true
        return left && right
    }
    return isSame(root, root.`val`)
}

private fun main() {

}
