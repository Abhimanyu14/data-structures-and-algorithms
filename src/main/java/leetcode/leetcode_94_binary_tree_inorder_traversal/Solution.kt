package leetcode.leetcode_94_binary_tree_inorder_traversal

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    fun bstInorderTraversal(current: TreeNode?) {
        current?.left?.let {
            bstInorderTraversal(it)
        }
        current?.`val`?.let {
            result.add(it)
        }
        current?.right?.let {
            bstInorderTraversal(it)
        }
    }
    bstInorderTraversal(root)
    return result
}

private fun main() {

}

